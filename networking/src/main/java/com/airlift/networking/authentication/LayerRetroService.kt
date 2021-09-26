package com.airlift.networking.authentication

import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LayerRetroService {
    @GET(LayerRepository.URL_LIVE_RATES)
    suspend fun fetchLiveRates(@Query("access_key") accessKey: String): Response<CoinlayerResponse>
}