package com.github.huangkl1024.defaultrunargs.project

import com.github.huangkl1024.defaultrunargs.MyBundle
import com.intellij.execution.util.ListTableWithButtons
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.modules
import com.intellij.openapi.ui.ComboBoxTableRenderer
import com.intellij.ui.components.fields.ExpandableTextField
import com.intellij.util.containers.stream
import com.intellij.util.containers.toArray
import com.intellij.util.ui.ColumnInfo
import com.intellij.util.ui.ListTableModel
import java.util.*
import javax.swing.DefaultCellEditor
import javax.swing.table.TableCellEditor

class ModuleJvmArgsTable(private val project: Project) : ListTableWithButtons<ModuleJvmArgsItem>() {
    private val myProject: Project = project

    override fun createListModel(): ListTableModel<*> {
        return ListTableModel<ModuleJvmArgsItem>(ModuleNameColumnInfo {
            myProject.modules.stream().map { it.name }
                .toList().toArray(emptyArray())
        }, JvmArgsColumnInfo())
    }

    override fun createElement(): ModuleJvmArgsItem {
        return ModuleJvmArgsItem("", "")
    }

    override fun isEmpty(element: ModuleJvmArgsItem?): Boolean {
        val empty = element?.moduleName?.isEmpty()
        return Objects.isNull(empty)
    }

    override fun cloneElement(variable: ModuleJvmArgsItem?): ModuleJvmArgsItem {
        return ModuleJvmArgsItem(variable?.moduleName, variable?.jvmArgs)
    }

    override fun canDeleteElement(selection: ModuleJvmArgsItem?): Boolean {
        return true
    }

    fun reset() {
        setValues(getPersistentState().moduleJvmArgsList)
    }

    fun apply() {
        getPersistentState().moduleJvmArgsList = elements
    }

    fun isModified(): Boolean {
        val sortedItems = elements.stream().sorted(compareBy { it.moduleName })
            .toList()
        val sortedSavedModuleJvmArgsList = getPersistentState().moduleJvmArgsList.stream()
            .sorted(compareBy { it.moduleName })
            .toList()
        if (sortedItems.size != sortedSavedModuleJvmArgsList.size) {
            return true
        }
        for ((index, item1) in sortedItems.withIndex()) {
            val item2 = sortedSavedModuleJvmArgsList[index]
            if (!Objects.equals(item1, item2)) {
                return true
            }
        }
        return false
    }

    private fun getPersistentState(): ProjectSettingsState {
        return ProjectSettingsPersistentData.getInstance(project).state
    }

    class ModuleNameColumnInfo(private val moduleNamesGetter: () -> Array<String>) :
        ColumnInfo<ModuleJvmArgsItem, String>(MyBundle.message("default.run.args.project.settings.module.jvm.args.table.column.module.name")) {
        override fun valueOf(item: ModuleJvmArgsItem?): String? {
            return item?.moduleName
        }

        override fun getEditor(item: ModuleJvmArgsItem?): TableCellEditor {
            return ComboBoxTableRenderer(moduleNamesGetter.invoke())
        }

        override fun isCellEditable(item: ModuleJvmArgsItem?): Boolean {
            return true
        }

        override fun setValue(item: ModuleJvmArgsItem?, value: String?) {
            item?.moduleName = value
        }
    }

    class JvmArgsColumnInfo :
        ColumnInfo<ModuleJvmArgsItem, String>(MyBundle.message("default.run.args.project.settings.module.jvm.args.table.column.jvm.args")) {
        override fun valueOf(item: ModuleJvmArgsItem?): String? {
            return item?.jvmArgs
        }

        override fun getEditor(item: ModuleJvmArgsItem?): TableCellEditor {
            return DefaultCellEditor(ExpandableTextField())
        }

        override fun isCellEditable(item: ModuleJvmArgsItem?): Boolean {
            return true
        }

        override fun setValue(item: ModuleJvmArgsItem?, value: String?) {
            item?.jvmArgs = value
        }
    }
}
