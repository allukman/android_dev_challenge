package com.karsatech.casestudy3

import com.karsatech.casestudy3.util.Helper.formatDate
import org.junit.Assert
import org.junit.Test

class DateUtilTest {

    @Test
    fun testFormatDate() {
        val inputDate = "21/01/2023"
        val expectedOutput = "21 January 2023"
        Assert.assertEquals(expectedOutput, formatDate(inputDate))
    }

    @Test(expected = Exception::class)
    fun testFormatDateInvalidInput() {
        val inputDate = "21-01-2023" // Input format is invalid
        formatDate(inputDate)
    }

}