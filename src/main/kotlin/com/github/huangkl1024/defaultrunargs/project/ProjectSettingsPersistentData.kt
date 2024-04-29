package com.github.huangkl1024.defaultrunargs.project

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "DefaultRunArgs", storages = [Storage("ProjectSettings.xml")])
class ProjectSettingsPersistentData : SimplePersistentStateComponent<ProjectSettingsState>(ProjectSettingsState()) {
    companion object Instance {
        fun getInstance(project: Project): ProjectSettingsPersistentData {
            return project.getService(ProjectSettingsPersistentData::class.java);
        }
    }
}

class ProjectSettingsState : BaseState() {
    var jvmArgs by string()
}
