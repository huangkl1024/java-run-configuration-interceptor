package com.github.huangkl1024.defaultrunargs

import com.intellij.openapi.options.Configurable
import java.util.*
import javax.swing.JComponent

abstract class AbstractSettings<T : AbstractSettingsPanel> : Configurable {
    private var myPanel: T? = null

    override fun createComponent(): JComponent {
        if (Objects.isNull(myPanel)) {
            myPanel = newComponent()
        }
        return myPanel!!.getComponent()
    }

    override fun isModified(): Boolean {
        return myPanel != null && myPanel!!.getComponent().isModified()
    }

    override fun apply() {
        if (myPanel == null) {
            return
        }
        myPanel!!.getComponent().apply()
    }

    override fun reset() {
        if (myPanel == null) {
            return
        }
        myPanel!!.getComponent().reset()
    }


    override fun disposeUIResources() {
        myPanel = null
    }

    abstract fun newComponent(): T
}
