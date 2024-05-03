package com.github.huangkl1024.defaultjvmargs.project


class ModuleJvmArgsItem() {
    var moduleName: String? = null
    var jvmArgs: String? = null

    constructor(moduleName: String?, jvmArgs: String?) : this() {
        this.moduleName = moduleName
        this.jvmArgs = jvmArgs
    }

    override fun toString(): String {
        return "ModuleJvmArgsItem(moduleName=$moduleName, jvmArgs=$jvmArgs)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ModuleJvmArgsItem

        if (moduleName != other.moduleName) return false
        if (jvmArgs != other.jvmArgs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = moduleName?.hashCode() ?: 0
        result = 31 * result + (jvmArgs?.hashCode() ?: 0)
        return result
    }
}
