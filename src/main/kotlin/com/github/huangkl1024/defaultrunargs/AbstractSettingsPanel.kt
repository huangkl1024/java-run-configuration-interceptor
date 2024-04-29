package com.github.huangkl1024.defaultrunargs

import com.intellij.openapi.ui.DialogPanel

fun interface AbstractSettingsPanel {
    /**
     * 获取组件
     */
    fun getComponent(): DialogPanel
}
