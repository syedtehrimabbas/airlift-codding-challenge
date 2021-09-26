package com.airlift.networking.authentication

import com.airlift.networking.apiclient.base.RetroApiResponse
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse

interface LayerApi {
    suspend fun fetchLiveRates(access_key: String): RetroApiResponse<CoinlayerResponse>
}