package com.github.huangkl1024.defaultrunargs

import com.github.huangkl1024.defaultrunargs.application.ApplicationSettingsPersistentData
import com.github.huangkl1024.defaultrunargs.project.ProjectSettingsPersistentData
import com.intellij.execution.JavaRunConfigurationBase
import com.intellij.execution.RunConfigurationExtension
import com.intellij.execution.configurations.CompositeParameterTargetedValue
import com.intellij.execution.configurations.JavaParameters
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.util.execution.ParametersListUtil

class DefaultRunArgsExtension : RunConfigurationExtension() {
    override fun isApplicableFor(configuration: RunConfigurationBase<*>): Boolean {
        return configuration is JavaRunConfigurationBase
    }

    override fun <T : RunConfigurationBase<*>?> updateJavaParameters(
        configuration: T & Any,
        params: JavaParameters,
        runnerSettings: RunnerSettings?
    ) {
        thisLogger().info("修改运行配置!")
        val jvmArgList = parseAllJvmArgs(configuration)
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

    private fun <T : RunConfigurationBase<*>?> parseAllJvmArgs(configuration: T & Any): MutableSet<String> {
        val jvmArgList = mutableSetOf<String>()
        // 添加全局配置
        parseJvmArgs(jvmArgList, ApplicationSettingsPersistentData.getInstance().jvmArgs)
        // 添加项目配置
        parseJvmArgs(jvmArgList, ProjectSettingsPersistentData.getInstance(configuration.project).state.jvmArgs)
        return jvmArgList
    }

    private fun parseJvmArgs(result: MutableSet<String>, jvmArgsStr: String?) {
        val jvmArgList = ArgsUtils.parseStrArgs(jvmArgsStr)
        jvmArgList.forEach { result.add(it) }
    }
}
