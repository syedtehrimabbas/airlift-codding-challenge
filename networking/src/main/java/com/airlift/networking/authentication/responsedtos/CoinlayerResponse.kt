package com.airlift.networking.authentication.responsedtos

import com.airlift.networking.apiclient.base.ApiResponse
import com.google.gson.annotations.SerializedName


/**

Created by Tehrim Abbas on 26/09/2021.

 **/

data class CoinlayerResponse(
    @SerializedName("rates")
    val rates: Map<String, Double> = HashMap(),
    @SerializedName("success")
    val success: Boolean,
) : ApiResponse()


data class CurrencyResponse(
    @SerializedName("crypto")
    val fiat: HashMap<String, CryptoMap> = HashMap(),
    @SerializedName("success")
    val success: Boolean,
) : ApiResponse()

data class CryptoMap(
    @SerializedName("icon_url")
    val icon_url: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_full")
    val name_full: String,
    @SerializedName("symbol")
    val symbol: String
)