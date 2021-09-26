package com.airlift.codingchallenge.ui.cryptorates

import com.airlift.codingchallenge.base.interfaces.IBase

interface ICryptoRates {
    interface View : IBase.View<ViewModel>

    interface ViewModel : IBase.ViewModel<State> {
        fun getCryptoRates()
    }

    interface State : IBase.State {
    }
}