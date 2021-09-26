package com.airlift.codingchallenge.utils

import com.airlift.networking.authentication.responsedtos.Currency
import com.airlift.networking.authentication.responsedtos.CurrencyRate


fun Map<*, *>.toCurrencyList() = map {
    Currency(
        it.key.toString(),
        it.value.toString()
    )
}

fun Map<String, Double>.toRatesList() = map {
    CurrencyRate(
        it.key,
        it.value
    )
}