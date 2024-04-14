package com.github.huangkl1024.javarunconfigurationinterceptor.configurable

import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ApplicationSettings
import com.github.huangkl1024.javarunconfigurationinterceptor.ui.ApplicationSettingForm
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ApplicationConfigurable : Configurable {
    private val form: ApplicationSettingForm = ApplicationSettingForm(ApplicationSettings.getInstance())

    override fun createComponent(): JComponent {
        return form.panel
    }

    override fun isModified(): Boolean {
        return form.panel.isModified()
    }

    override fun apply() {
        form.panel.apply()
    }

    override fun getDisplayName(): String {
        return "Java程序运行配置拦截器（全局）"
    }
}
