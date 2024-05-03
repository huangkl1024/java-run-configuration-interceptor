package com.github.huangkl1024.defaultjvmargs.project

import com.github.huangkl1024.defaultjvmargs.AbstractSettings
import com.github.huangkl1024.defaultjvmargs.MyBundle
import com.intellij.openapi.project.Project

class ProjectSettings(private val project: Project) : AbstractSettings<ProjectSettingsPanel>() {

    override fun newComponent(): ProjectSettingsPanel {
        return ProjectSettingsPanel(project)
    }


    override fun getDisplayName(): String {
        return MyBundle.message("default.jvm.args.project.settings.display.name")
    }
}
