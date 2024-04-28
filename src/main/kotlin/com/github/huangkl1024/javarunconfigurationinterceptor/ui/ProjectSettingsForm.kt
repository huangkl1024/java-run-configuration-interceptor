package com.github.huangkl1024.javarunconfigurationinterceptor.ui

import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ProjectSettingsState
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.RowLayout
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel

class ProjectSettingsForm(model: ProjectSettingsState) {
    val panel = panel {
        group("项目参数") {
            row("JVM参数:") {
                expandableTextField()
                    .bindText({
                        model.jvmArgs.orEmpty()
                    }, { model.jvmArgs = it })
                    .resizableColumn()
                    .align(AlignX.FILL)
            }.layout(RowLayout.PARENT_GRID)
        }
    }
}
