package com.github.huangkl1024.defaultjvmargs.project

import com.github.huangkl1024.defaultjvmargs.AbstractSettingsPanel
import com.github.huangkl1024.defaultjvmargs.MyBundle
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.RowLayout
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel

class ProjectSettingsPanel(project: Project) : AbstractSettingsPanel {
    private val moduleJvmArgsTable: ModuleJvmArgsTable = ModuleJvmArgsTable(project)

    private val root = panel {
        val persistentData = ProjectSettingsPersistentData.getInstance(project)
        group(MyBundle.message("default.jvm.args.project.settings.project")) {
            row(MyBundle.message("default.jvm.args.project.settings.jvm.args")) {
                expandableTextField()
                    .bindText({
                        persistentData.state.jvmArgs.orEmpty()
                    }, { persistentData.state.jvmArgs = it })
                    .resizableColumn()
                    .align(AlignX.FILL)
            }.layout(RowLayout.PARENT_GRID)
        }
        group(MyBundle.message("default.jvm.args.project.settings.module.jvm.args.table.title")) {
            row {
                cell(moduleJvmArgsTable.component)
                    .align(AlignX.FILL)
                    .onApply { moduleJvmArgsTable.apply() }
                    .onReset { moduleJvmArgsTable.reset() }
                    .onIsModified { moduleJvmArgsTable.isModified() }
            }
        }
    }

    override fun getComponent(): DialogPanel {
        return root
    }
}
