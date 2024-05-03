package com.github.huangkl1024.defaultjvmargs.project

import com.intellij.openapi.components.*
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "DefaultJvmArgs", storages = [Storage("DefaultJvmArgs.xml")])
class ProjectSettingsPersistentData : SimplePersistentStateComponent<ProjectSettingsState>(ProjectSettingsState()) {
    companion object Instance {
        fun getInstance(project: Project): ProjectSettingsPersistentData {
            return project.getService(ProjectSettingsPersistentData::class.java);
        }
    }
}

class ProjectSettingsState : BaseState() {
    var jvmArgs by string()
    var moduleJvmArgsList by list<ModuleJvmArgsItem>()
}
