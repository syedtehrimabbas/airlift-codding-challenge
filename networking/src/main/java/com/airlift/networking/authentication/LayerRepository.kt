package com.airlift.networking.authentication

import com.airlift.networking.apiclient.base.BaseRepository
import com.airlift.networking.apiclient.base.RetroApiResponse
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import com.airlift.networking.authentication.responsedtos.CurrencyResponse
import javax.inject.Inject

class LayerRepository @Inject constructor(private val service: LayerRetroService) :
    BaseRepository(),
    LayerApi {
    override suspend fun fetchLiveRates(accessKey: String): RetroApiResponse<CoinlayerResponse> =
        executeSafely(call = { service.fetchLiveRates(accessKey) })

    override suspend fun fetchCryptoCurrencies(accessKey: String): RetroApiResponse<CurrencyResponse> =
        executeSafely(call = { service.fetchCryptoCurrencies(accessKey) })

    companion object {
        const val URL_LIVE_RATES = "/api/live"
        const val URL_CURRENCIES_LIST = "/api/list"
    }
}
