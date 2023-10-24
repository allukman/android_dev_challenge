package com.karsatech.casestudy1.core.util

object Helper {
    fun isValidBarcodeFormat(barcodeResult: String, saldo: Int): Boolean {
        val barcodeParts = barcodeResult.split('.')
        if (barcodeParts.size != 4) {
            return false
        }

        val amount = barcodeParts[3].toIntOrNull()
        if (amount == null || amount <= 1000 || amount > saldo) {
            return false
        }

        return true
    }

    fun Int.addThousandSeparator() : String {
        val numberFormat = java.text.NumberFormat.getInstance()
        return numberFormat.format(this)
    }
}