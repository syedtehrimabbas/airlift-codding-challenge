package com.airlift.codingchallenge.ui.cryptorates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.airlift.codingchallenge.base.interfaces.IBase
import com.airlift.codingchallenge.ui.adapters.CurrencyRatesAdapter
import com.airlift.codingchallenge.utils.SingleEvent
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import com.airlift.networking.authentication.responsedtos.CurrencyResponse

interface ICryptoRates {
    interface View : IBase.View<ViewModel>

    interface ViewModel : IBase.ViewModel<State> {
        fun getCryptoRates()
        fun loadCurrencies()
        val errorMessagePrivat: MutableLiveData<SingleEvent<Any>>
        val errorMessage: LiveData<SingleEvent<Any>>
    }

    interface State : IBase.State {
        var currencyRatesAdapter: MutableLiveData<CurrencyRatesAdapter>

        val currenciesLiveDataPrivate: MutableLiveData<CurrencyResponse>
        val currenciesLiveData: LiveData<CurrencyResponse>

        val ratesLiveDataPrivate: MutableLiveData<CoinlayerResponse>
        val ratesLiveData: LiveData<CoinlayerResponse>
        var selectedCurrency: String
        var amount: Double
        var shimmerVisibility: MutableLiveData<Boolean>
    }
}