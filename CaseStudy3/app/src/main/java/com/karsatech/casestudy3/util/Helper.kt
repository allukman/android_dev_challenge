package com.karsatech.casestudy3.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Helper {

    fun formatDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        var date: Date? = null
        try {
            date = inputFormat.parse(inputDate)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return outputFormat.format(date!!)
    }

    fun Int.addThousandSeparator() : String {
        val numberFormat = java.text.NumberFormat.getInstance()
        return numberFormat.format(this)
    }
}