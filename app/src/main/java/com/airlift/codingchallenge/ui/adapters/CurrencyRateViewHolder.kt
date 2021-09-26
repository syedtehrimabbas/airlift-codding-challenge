package com.airlift.codingchallenge.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.airlift.codingchallenge.databinding.ItemCurrencyRateBinding
import com.airlift.networking.authentication.responsedtos.CurrencyRate

class CurrencyRateViewHolder(private val itemCurrencyRateBinding: ItemCurrencyRateBinding) :
    RecyclerView.ViewHolder(itemCurrencyRateBinding.root) {

    fun onBind(currencyRate: CurrencyRate?) {
        itemCurrencyRateBinding.rate = currencyRate?.rate
        itemCurrencyRateBinding.currency = currencyRate?.currencyCode
        itemCurrencyRateBinding.executePendingBindings()
    }
}