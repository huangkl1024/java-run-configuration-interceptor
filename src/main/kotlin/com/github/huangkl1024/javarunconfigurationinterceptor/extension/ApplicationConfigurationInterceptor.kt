package com.github.huangkl1024.javarunconfigurationinterceptor.extension

import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ApplicationSettings
import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ProjectSettings
import com.github.huangkl1024.javarunconfigurationinterceptor.util.JvmArgsParser
import com.intellij.execution.RunConfigurationExtension
import com.intellij.execution.application.ApplicationConfiguration
import com.intellij.execution.configurations.CompositeParameterTargetedValue
import com.intellij.execution.configurations.JavaParameters
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.util.execution.ParametersListUtil

class ApplicationConfigurationInterceptor : RunConfigurationExtension() {
    override fun isApplicableFor(configuration: RunConfigurationBase<*>): Boolean {
        return configuration is ApplicationConfiguration
    }

    override fun <T : RunConfigurationBase<*>?> updateJavaParameters(configuration: T & Any, params: JavaParameters, runnerSettings: RunnerSettings?) {
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
        parseJvmArgs(jvmArgList, ApplicationSettings.getInstance().jvmArgs)
        // 添加项目配置
        parseJvmArgs(jvmArgList, ProjectSettings.getInstance(configuration.project).state.jvmArgs)
        return jvmArgList
    }

    private fun parseJvmArgs(result: MutableSet<String>, jvmArgsStr: String?) {
        val jvmArgList = JvmArgsParser.parseJvmArgs(jvmArgsStr)
        jvmArgList.forEach { result.add(it) }
    }
}
