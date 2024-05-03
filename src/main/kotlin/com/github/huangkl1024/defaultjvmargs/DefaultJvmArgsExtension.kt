package com.github.huangkl1024.defaultjvmargs

import com.github.huangkl1024.defaultjvmargs.application.ApplicationSettingsPersistentData
import com.github.huangkl1024.defaultjvmargs.project.ProjectSettingsPersistentData
import com.github.huangkl1024.defaultjvmargs.project.ProjectSettingsState
import com.intellij.execution.JavaRunConfigurationBase
import com.intellij.execution.RunConfigurationExtension
import com.intellij.execution.configurations.*
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.util.execution.ParametersListUtil

class DefaultJvmArgsExtension : RunConfigurationExtension() {
    override fun isApplicableFor(configuration: RunConfigurationBase<*>): Boolean {
        return configuration is JavaRunConfigurationBase
    }

    override fun <T : RunConfigurationBase<*>?> updateJavaParameters(
        configuration: T & Any,
        params: JavaParameters,
        runnerSettings: RunnerSettings?
    ) {
        thisLogger().info("修改运行配置!")
        val jvmArgList = addAllJvmArgs(configuration)
        if (jvmArgList.isEmpty()) {
            return
        }
        val vmParametersList = params.vmParametersList
        val parametersString = vmParametersList.parametersString
        val addedJvmArgList = mutableListOf<String>()
        for (jvmArg in jvmArgList) {
            if (!parametersString.contains(jvmArg)) {
                vmParametersList.add(CompositeParameterTargetedValue(jvmArg))
                addedJvmArgList.add(jvmArg)
            }
        }
        thisLogger().info("添加了 ${ParametersListUtil.join(addedJvmArgList)} 参数!")
    }

    private fun <T : RunConfigurationBase<*>?> addAllJvmArgs(configuration: T & Any): MutableSet<String> {
        val jvmArgList = mutableSetOf<String>()
        // 添加全局配置
        parseJvmArgs(jvmArgList, ApplicationSettingsPersistentData.getInstance().jvmArgs)
        // 添加项目配置
        val projectSettingsState = ProjectSettingsPersistentData.getInstance(configuration.project).state
        parseJvmArgs(jvmArgList, projectSettingsState.jvmArgs)
        // 模块 JVM 参数
        addModuleJvmArgsIfNeed<T>(configuration, projectSettingsState, jvmArgList)

        return jvmArgList
    }

    private fun <T : RunConfigurationBase<*>?> addModuleJvmArgsIfNeed(
        configuration: T & Any,
        projectSettingsState: ProjectSettingsState,
        jvmArgList: MutableSet<String>
    ) {
        val state = configuration.state
        if (state is ModuleBasedConfigurationOptions && projectSettingsState.moduleJvmArgsList.isNotEmpty()) {
            val module = state.module
            projectSettingsState.moduleJvmArgsList.stream().filter { it.moduleName.equals(module) }
                .forEach { parseJvmArgs(jvmArgList, it.jvmArgs) }
        }
    }

    private fun parseJvmArgs(result: MutableSet<String>, jvmArgsStr: String?) {
        val jvmArgList = ArgsUtils.parseStrArgs(jvmArgsStr)
        jvmArgList.forEach { result.add(it) }
    }
}
