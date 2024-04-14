package com.github.huangkl1024.javarunconfigurationinterceptor.ui

import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ProjectSettingsState
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel

class ProjectSettingsForm(model: ProjectSettingsState) {
    val panel = panel {
        row("JVM 参数:") {
            expandableTextField()
                    .bindText({
                        model.jvmArgs.orEmpty()
                    }, { model.jvmArgs = it })
        }
    }
}
