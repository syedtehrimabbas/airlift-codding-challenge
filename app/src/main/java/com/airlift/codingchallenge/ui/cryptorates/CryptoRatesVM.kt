package com.airlift.codingchallenge.ui.cryptorates

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.airlift.codingchallenge.BuildConfig
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel
import com.airlift.codingchallenge.utils.SingleEvent
import com.airlift.codingchallenge.utils.formattedAmount
import com.airlift.codingchallenge.utils.parseDouble
import com.airlift.codingchallenge.utils.toRatesList
import com.airlift.networking.apiclient.base.RetroApiResponse
import com.airlift.networking.authentication.LayerApi
import com.airlift.networking.authentication.responsedtos.CurrencyRate
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoRatesVM @Inject constructor(
    override val viewState: CryptoRatesState,
    val layerApi: LayerApi,
) : HiltBaseViewModel<ICryptoRates.State>(), ICryptoRates.ViewModel {
    override val errorMessagePrivat: MutableLiveData<SingleEvent<Any>> =
        MutableLiveData<SingleEvent<Any>>()
    override val errorMessage: LiveData<SingleEvent<Any>> get() = errorMessagePrivat

    override fun handleOnClick(id: Int) {}

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        loadCurrencies()
        getCryptoRates()
    }

    override fun getCryptoRates() {
        viewState.shimmerVisibility.value = true
        launch {
            when (val response = layerApi.fetchLiveRates(
                BuildConfig.API_KEY
            )) {
                is RetroApiResponse.Success -> {
                    viewState.shimmerVisibility.postValue(false)
                    viewState.ratesLiveDataPrivate.postValue(response.data)
                }
                is RetroApiResponse.Error -> {
                    viewState.shimmerVisibility.postValue(false)
                    errorMessagePrivat.value =
                        SingleEvent(response.error.message)
                }
            }
        }
    }

    override fun loadCurrencies() {
        launch {
            when (val response = layerApi.fetchCryptoCurrencies(
                BuildConfig.API_KEY
            )) {
                is RetroApiResponse.Success -> {
                    viewState.currenciesLiveDataPrivate.postValue(response.data)
                }
                is RetroApiResponse.Error -> {
                    errorMessagePrivat.value =
                        SingleEvent(response.error.message)
                }
            }
        }
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        viewState.amount = s.toString().parseDouble()
        calculateRates()
    }

    fun onSelectItem(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        parent?.selectedItem.apply {
            viewState.selectedCurrency = this as String
            calculateRates()
        }
    }

    private fun calculateRates() {
        viewState.ratesLiveDataPrivate.value?.let {
            viewState.currencyRatesAdapter.value?.setList(
                getRatesForCurrency(
                    viewState.amount,
                    viewState.selectedCurrency,
                    it.rates.toRatesList()
                )
            )
        }
    }

    private fun getRatesForCurrency(
        amount: Double,
        selectedCurrency: String,
        actualRates: List<CurrencyRate>
    ): List<CurrencyRate> {

        val rate =
            actualRates.find { it.currencyCode == selectedCurrency }
        val sourceRate = amount.div(rate?.rate ?: 0.01)
        return actualRates.map {
            CurrencyRate(
                "$selectedCurrency → ${it.currencyCode}",
                (sourceRate.times(it.rate).formattedAmount())
            )
        }
    }

}