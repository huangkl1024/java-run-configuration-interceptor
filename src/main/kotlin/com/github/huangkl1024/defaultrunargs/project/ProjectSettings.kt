package com.github.huangkl1024.defaultrunargs.project

import com.github.huangkl1024.defaultrunargs.AbstractSettings
import com.github.huangkl1024.defaultrunargs.MyBundle
import com.intellij.openapi.project.Project

class ProjectSettings(private val project: Project) : AbstractSettings<ProjectSettingsPanel>() {

    override fun newComponent(): ProjectSettingsPanel {
        return ProjectSettingsPanel(project)
    }


    override fun getDisplayName(): String {
        return MyBundle.message("default.run.args.project.settings.display.name")
    }
}
