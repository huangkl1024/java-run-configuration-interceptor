package com.github.huangkl1024.javarunconfigurationinterceptor.configurable

import com.github.huangkl1024.javarunconfigurationinterceptor.persistent.ProjectSettings
import com.github.huangkl1024.javarunconfigurationinterceptor.ui.ProjectSettingsForm
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent

class ProjectConfigurable(project: Project) : Configurable {
    private val form = ProjectSettingsForm(ProjectSettings.getInstance(project).state)

    override fun createComponent(): JComponent {
        return this.form.panel
    }

    override fun isModified(): Boolean {
        return this.form.panel.isModified()
    }

    override fun apply() {
        this.form.panel.apply()
    }

    override fun getDisplayName(): String {
        return "Java程序运行配置拦截器（项目）"
    }
}
