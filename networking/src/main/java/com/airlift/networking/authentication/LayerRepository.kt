package com.airlift.networking.authentication

import com.airlift.networking.apiclient.base.BaseRepository
import com.airlift.networking.apiclient.base.RetroApiResponse
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import javax.inject.Inject

class LayerRepository @Inject constructor(private val service: LayerRetroService) :
    BaseRepository(),
    LayerApi {
    override suspend fun fetchLiveRates(accessKey: String): RetroApiResponse<CoinlayerResponse> =
        executeSafely(call = { service.fetchLiveRates(accessKey) })

    companion object {
        const val URL_LIVE_RATES = "/api/live"
    }
}
