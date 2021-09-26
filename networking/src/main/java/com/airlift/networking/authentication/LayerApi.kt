package com.airlift.networking.authentication

import com.airlift.networking.apiclient.base.RetroApiResponse
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import com.airlift.networking.authentication.responsedtos.CurrencyResponse

interface LayerApi {
    suspend fun fetchLiveRates(accessKey: String): RetroApiResponse<CoinlayerResponse>
    suspend fun fetchCryptoCurrencies(accessKey: String): RetroApiResponse<CurrencyResponse>
}