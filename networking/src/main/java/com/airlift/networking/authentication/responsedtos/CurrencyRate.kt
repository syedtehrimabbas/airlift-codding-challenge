package com.airlift.networking.authentication.responsedtos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CurrencyRate(val currencyCode: String, val rate: Double) : Parcelable {
    override fun toString(): String {
        return rate.toString()
    }
}