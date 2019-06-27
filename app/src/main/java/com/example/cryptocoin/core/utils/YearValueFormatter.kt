package com.example.cryptocoin.core.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.util.*

class YearValueFormatter : IAxisValueFormatter {

    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = value.toLong()
        return calendar.toFormatted()
    }

    private fun Calendar.toFormatted(): String {
        val date: Long = this.timeInMillis
        return date.dateToString("MMM yyyy")
    }
}