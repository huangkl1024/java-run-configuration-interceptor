package com.github.huangkl1024.defaultjvmargs.application

import com.github.huangkl1024.defaultjvmargs.AbstractSettings
import com.github.huangkl1024.defaultjvmargs.MyBundle

class ApplicationSettings : AbstractSettings<ApplicationSettingsPanel>() {
    override fun newComponent(): ApplicationSettingsPanel {
        return ApplicationSettingsPanel()
    }


    override fun getDisplayName(): String {
        return MyBundle.message("default.jvm.args.application.settings.display.name")
    }
}
