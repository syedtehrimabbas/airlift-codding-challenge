package com.airlift.networking.authentication.responsedtos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Currency(val code: String, val currencyName: String?) : Parcelable {
    override fun toString(): String {
        return currencyName.toString()
    }
}