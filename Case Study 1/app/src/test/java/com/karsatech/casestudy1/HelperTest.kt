package com.karsatech.casestudy1

import com.karsatech.casestudy1.core.util.Helper
import com.karsatech.casestudy1.core.util.Helper.addThousandSeparator
import org.junit.Assert
import org.junit.Test

class HelperTest {

    @Test
    fun testIsValidBarcodeFormatValidInput() {
        val barcodeResult = "BNI.ID12345678.MERCHANT MOCK TEST.50000"
        val saldo = 100000
        Assert.assertTrue(Helper.isValidBarcodeFormat(barcodeResult, saldo))
    }

    @Test
    fun testIsValidBarcodeFormatInvalidInput() {
        val barcodeResult = " BNI.ID12345678.MERCHANT MOCK TEST.20000" // saldo kurang dari pembayaran
        val saldo = 10000
        Assert.assertFalse(Helper.isValidBarcodeFormat(barcodeResult, saldo))
    }

    @Test
    fun testAddThousandSeparator() {
        val number = 123456789
        val expectedOutput = "123,456,789"
        Assert.assertEquals(expectedOutput, number.addThousandSeparator())
    }
}