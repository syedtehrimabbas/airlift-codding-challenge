package com.airlift.codingchallenge.ui.adapters

import androidx.databinding.ViewDataBinding
import com.airlift.codingchallenge.R
import com.airlift.codingchallenge.databinding.ItemCurrencyRateBinding
import com.airlift.networking.authentication.responsedtos.CurrencyRate

class CurrencyRatesAdapter(val data: MutableList<CurrencyRate>) :
    BaseBindingRecyclerAdapter<CurrencyRate, CurrencyRateViewHolder>(data) {

    override fun onCreateViewHolder(binding: ViewDataBinding): CurrencyRateViewHolder =
        CurrencyRateViewHolder(
            binding as ItemCurrencyRateBinding
        )

    override fun onBindViewHolder(holder: CurrencyRateViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.onBind(getDataForPosition(position))
    }

    override fun getLayoutIdForViewType(viewType: Int): Int = R.layout.item_currency_rate

}
