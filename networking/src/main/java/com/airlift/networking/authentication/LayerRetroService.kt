package com.airlift.networking.authentication

import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import com.airlift.networking.authentication.responsedtos.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LayerRetroService {
    @GET(LayerRepository.URL_LIVE_RATES)
    suspend fun fetchLiveRates(@Query("access_key") accessKey: String): Response<CoinlayerResponse>

    @GET(LayerRepository.URL_CURRENCIES_LIST)
    suspend fun fetchCryptoCurrencies(@Query("access_key") accessKey: String): Response<CurrencyResponse>
}