package com.airlift.codingchallenge.ui.cryptorates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.airlift.codingchallenge.base.state.BaseState
import com.airlift.codingchallenge.ui.adapters.CurrencyRatesAdapter
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import com.airlift.networking.authentication.responsedtos.CurrencyResponse
import javax.inject.Inject

class CryptoRatesState @Inject constructor() : BaseState(), ICryptoRates.State {
    override var currencyRatesAdapter: MutableLiveData<CurrencyRatesAdapter> =
        MutableLiveData(CurrencyRatesAdapter(mutableListOf()))

    override val currenciesLiveDataPrivate: MutableLiveData<CurrencyResponse> =
        MutableLiveData<CurrencyResponse>()
    override val currenciesLiveData: LiveData<CurrencyResponse> = currenciesLiveDataPrivate
    override val ratesLiveDataPrivate: MutableLiveData<CoinlayerResponse> =
        MutableLiveData<CoinlayerResponse>()
    override val ratesLiveData: LiveData<CoinlayerResponse> = ratesLiveDataPrivate
    override var amount: Double = 1.0
    override var selectedCurrency: String = ""
    override var shimmerVisibility: MutableLiveData<Boolean> = MutableLiveData(true)
}