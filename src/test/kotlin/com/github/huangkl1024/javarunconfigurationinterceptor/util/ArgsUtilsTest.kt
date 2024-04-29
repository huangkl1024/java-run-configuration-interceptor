package com.github.huangkl1024.javarunconfigurationinterceptor.util

import com.github.huangkl1024.defaultrunargs.ArgsUtils
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase

class ArgsUtilsTest : BasePlatformTestCase(){


    fun testParseJvmArgs() {
        val parseJvmArgs1 = ArgsUtils.parseStrArgs("-Dtest1=test1")
        TestCase.assertTrue(parseJvmArgs1.size == 1)
        val parseJvmArgs2 = ArgsUtils.parseStrArgs("-Dtest1=test1 -Dtest2=test2")
        TestCase.assertTrue(parseJvmArgs2.size == 2)
        TestCase.assertEquals("-Dtest1=test1", parseJvmArgs2[0])
        TestCase.assertEquals("-Dtest2=test2", parseJvmArgs2[1])
        val parseJvmArgs3 = ArgsUtils.parseStrArgs("-Dtest1=test1   -Dtest2=test2")
        TestCase.assertTrue(parseJvmArgs2.size == 2)
        TestCase.assertEquals("-Dtest1=test1", parseJvmArgs3[0])
        TestCase.assertEquals("-Dtest2=test2", parseJvmArgs3[1])
        val testStr = """
            -Dtest1=test1
            -Dtest2=test2
        """
        val parseJvmArgs4 = ArgsUtils.parseStrArgs(testStr.trimIndent())
        TestCase.assertTrue(parseJvmArgs2.size == 2)
        TestCase.assertEquals("-Dtest1=test1", parseJvmArgs4[0])
        TestCase.assertEquals("-Dtest2=test2", parseJvmArgs4[1])
    }
}
