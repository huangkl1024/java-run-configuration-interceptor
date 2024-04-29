package com.github.huangkl1024.defaultrunargs

object ArgsUtils {

    /**
     * 解析字符串参数
     *
     */
    @JvmStatic
    fun parseStrArgs(str: String?): List<String> {
        if (str.isNullOrBlank()) {
            return emptyList()
        }
        val split = str.split(" ", "\t", "\n")
        return split.stream()
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .toList()
    }
}
