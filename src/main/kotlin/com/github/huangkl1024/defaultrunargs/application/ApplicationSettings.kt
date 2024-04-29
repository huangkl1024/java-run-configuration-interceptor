package com.github.huangkl1024.defaultrunargs.application

import com.github.huangkl1024.defaultrunargs.AbstractSettings
import com.github.huangkl1024.defaultrunargs.MyBundle

class ApplicationSettings : AbstractSettings<ApplicationSettingsPanel>() {
    override fun newComponent(): ApplicationSettingsPanel {
        return ApplicationSettingsPanel()
    }


    override fun getDisplayName(): String {
        return MyBundle.message("default.run.args.application.settings.display.name")
    }
}
