package com.airlift.codingchallenge.ui.cryptorates

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.airlift.codingchallenge.BR
import com.airlift.codingchallenge.R
import com.airlift.codingchallenge.base.fragments.BaseBindingViewModelFragment
import com.airlift.codingchallenge.databinding.FragmentCryptoRatesBinding
import com.airlift.codingchallenge.utils.SingleEvent
import com.airlift.codingchallenge.utils.observe
import com.airlift.codingchallenge.utils.setupSnackbar
import com.airlift.codingchallenge.utils.toRatesList
import com.airlift.networking.authentication.responsedtos.CoinlayerResponse
import com.airlift.networking.authentication.responsedtos.CurrencyResponse
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoRatesFragment :
    BaseBindingViewModelFragment<FragmentCryptoRatesBinding, ICryptoRates.State, CryptoRatesVM>() {
    override val viewModel: CryptoRatesVM by viewModels()
    override val bindingVariableId = BR.viewModel
    override val bindingViewStateVariableId = BR.viewState
    override val layoutResId: Int = R.layout.fragment_crypto_rates
    override fun onClick(id: Int) {}
    override fun getToolBarTitle(): String = getString(R.string.crypto_rates)

    override fun toolBarVisibility(): Boolean = true

    override fun setDisplayHomeAsUpEnabled(): Boolean = false
    override fun setHomeAsUpIndicator(): Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        startObservers()
    }

    private fun handleCurrency(currencyResponse: CurrencyResponse) =
        bindCurrencyAdapter(currencyResponse)

    private fun handleRates(ratesResponse: CoinlayerResponse) {
        mViewDataBinding.shimmerViewContainer.stopShimmerAnimation()
        viewState.currencyRatesAdapter.value?.setList(ratesResponse.rates.toRatesList())
    }

    private fun bindCurrencyAdapter(currenciesResponse: CurrencyResponse) {
        if (currenciesResponse.success) {
            setSpinnerItems(
                mViewDataBinding.currencyAS,
                currenciesResponse.fiat.entries.map { it.key })
        }
    }

    private fun shimmerVisibility(isVisible: Boolean) {
        if (isVisible)
            mViewDataBinding.shimmerViewContainer.startShimmerAnimation()
        else
            mViewDataBinding.shimmerViewContainer.stopShimmerAnimation()
    }

    private fun startObservers() {
        observe(viewState.currenciesLiveData, ::handleCurrency)
        observe(viewState.ratesLiveData, ::handleRates)
        observe(viewState.shimmerVisibility, ::shimmerVisibility)
        observeSnackBarMessages(viewModel.errorMessage)
    }

    private fun setSpinnerItems(spinner: AppCompatSpinner, list: List<String>) {
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                list.sorted()
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    private fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>) {
        mViewDataBinding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_actions, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_refresh -> {
                viewModel.onFirsTimeUiCreate(Bundle())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}