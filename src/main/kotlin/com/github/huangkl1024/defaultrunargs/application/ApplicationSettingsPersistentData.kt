package com.github.huangkl1024.defaultrunargs.application

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@Service(Service.Level.APP)
@State(name = "DefaultRunArgs", storages = [Storage("ApplicationSettings.xml")])
class ApplicationSettingsPersistentData : PersistentStateComponent<ApplicationSettingsPersistentData> {
    var jvmArgs: String = ""

    override fun getState(): ApplicationSettingsPersistentData {
        return this
    }

    override fun loadState(state: ApplicationSettingsPersistentData) {
        XmlSerializerUtil.copyBean(state, this);
    }

    companion object Instance {
        fun getInstance(): ApplicationSettingsPersistentData {
            return ApplicationManager.getApplication().getService(ApplicationSettingsPersistentData::class.java);
        }
    }
}
