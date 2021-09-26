package com.airlift.codingchallenge.ui.splash

import androidx.lifecycle.MutableLiveData
import com.airlift.codingchallenge.base.interfaces.IBase

interface ISplash {
    interface View : IBase.View<ViewModel>
    interface ViewModel : IBase.ViewModel<State> {
    }

    interface State : IBase.State {
        var proceedNext: MutableLiveData<Boolean>
    }
}