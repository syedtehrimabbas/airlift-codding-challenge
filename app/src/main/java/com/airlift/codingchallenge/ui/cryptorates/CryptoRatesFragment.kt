package com.airlift.codingchallenge.ui.cryptorates

import androidx.fragment.app.viewModels
import com.airlift.codingchallenge.BR
import com.airlift.codingchallenge.R
import com.airlift.codingchallenge.base.fragments.BaseBindingViewModelFragment
import com.airlift.codingchallenge.databinding.FragmentCryptoRatesBinding
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
}