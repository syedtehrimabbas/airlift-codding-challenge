package com.airlift.codingchallenge.utils

import java.text.DecimalFormat

fun Double.formattedAmount(): Double {
    val formatted = DecimalFormat("##0.####").format(this)
    return formatted.parseDouble()
}
