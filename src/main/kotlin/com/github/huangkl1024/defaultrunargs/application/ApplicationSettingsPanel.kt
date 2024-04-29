package com.github.huangkl1024.defaultrunargs.application

import com.github.huangkl1024.defaultrunargs.AbstractSettingsPanel
import com.github.huangkl1024.defaultrunargs.MyBundle
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel

class ApplicationSettingsPanel : AbstractSettingsPanel {

    private val root = panel {
        val persistentData = ApplicationSettingsPersistentData.getInstance()
        row(MyBundle.message("default.run.args.application.settings.jvm.args")) {
            expandableTextField()
                .bindText(persistentData::jvmArgs)
                .resizableColumn()
                .align(AlignX.FILL)
        }
    }

    override fun getComponent(): DialogPanel {
        return root
    }

}
