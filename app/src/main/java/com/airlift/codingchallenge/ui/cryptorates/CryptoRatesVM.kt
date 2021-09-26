package com.airlift.codingchallenge.ui.cryptorates

import android.os.Bundle
import com.airlift.codingchallenge.BuildConfig
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel
import com.airlift.networking.apiclient.base.RetroApiResponse
import com.airlift.networking.authentication.LayerApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoRatesVM @Inject constructor(
    override val viewState: CryptoRatesState,
    val layerApi: LayerApi,
) : HiltBaseViewModel<ICryptoRates.State>(), ICryptoRates.ViewModel {

    override fun handleOnClick(id: Int) {

    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        getCryptoRates()
    }

    override fun getCryptoRates() {
        launch {
            when (val response = layerApi.fetchLiveRates(
                BuildConfig.API_KEY
            )) {
                is RetroApiResponse.Success -> {
                    loading(false)
                }
                is RetroApiResponse.Error -> {
                    alert(response.error.message)
                    loading(false)
                }
            }
        }
    }
}