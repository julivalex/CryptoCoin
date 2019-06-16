package com.example.cryptocoin.utils

import java.text.SimpleDateFormat
import java.util.*


fun Float.formatThousands(): String {
    StringBuilder().apply {
        Formatter(this, Locale.US).format("%(,.0f)", this@formatThousands)
        return toString()
    }
}

fun Number.dateToString(pattern: String): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.toLong()
    return SimpleDateFormat(pattern, Locale.US).format(calendar.time)
}