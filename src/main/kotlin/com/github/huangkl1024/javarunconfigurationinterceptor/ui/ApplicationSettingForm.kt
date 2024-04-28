package com.github.huangkl1024.javarunconfigurationinterceptor.ui

import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ApplicationSettings
import com.intellij.ui.dsl.builder.*

class ApplicationSettingForm(model: ApplicationSettings) {

    val panel = panel {
        row("JVM 参数:") {
            expandableTextField()
                .bindText(model::jvmArgs)
                .resizableColumn()
                .align(AlignX.FILL)
        }
    }
}
