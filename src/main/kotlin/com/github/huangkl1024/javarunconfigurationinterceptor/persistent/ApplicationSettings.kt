package com.github.huangkl1024.javarunconfigurationinterceptor.persistent

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@Service(Service.Level.APP)
@State(name = "java-run-configuration-interceptor", storages = [Storage("application-settings.xml")])
class ApplicationSettings : PersistentStateComponent<ApplicationSettings> {
    var jvmArgs: String = ""

    override fun getState(): ApplicationSettings {
        return this
    }

    override fun loadState(state: ApplicationSettings) {
        XmlSerializerUtil.copyBean(state, this);
    }

    companion object Instance {
        fun getInstance(): ApplicationSettings {
            return ApplicationManager.getApplication().getService(ApplicationSettings::class.java);
        }
    }
}
