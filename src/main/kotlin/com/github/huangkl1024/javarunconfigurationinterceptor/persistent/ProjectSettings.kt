package com.github.huangkl1024.javarunconfigurationinterceptor.persistent

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "java-run-configuration-interceptor", storages = [Storage("project-settings.xml")])
class ProjectSettings : SimplePersistentStateComponent<ProjectSettingsState>(ProjectSettingsState()) {
    companion object Instance {
        fun getInstance(project: Project): ProjectSettings {
            return project.getService(ProjectSettings::class.java);
        }
    }
}

class ProjectSettingsState : BaseState() {
    var jvmArgs by string()
}
