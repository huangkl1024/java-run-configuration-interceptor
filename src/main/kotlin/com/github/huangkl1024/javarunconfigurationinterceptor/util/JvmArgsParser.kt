package com.github.huangkl1024.javarunconfigurationinterceptor.util

object JvmArgsParser {

    @JvmStatic
    fun parseJvmArgs(jvmArgsStr: String?): List<String> {
        if (jvmArgsStr.isNullOrBlank()) {
            return emptyList()
        }
        val split = jvmArgsStr.split(" ", "\t", "\n")
        return split.stream()
                .map { it.trim() }
                .filter { it.isNotBlank() }
                .toList()
    }
}
