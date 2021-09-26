package com.airlift.codingchallenge.ui.main

import com.airlift.codingchallenge.base.interfaces.IBase

interface IMainActivity {
    interface View : IBase.View<ViewModel>
    interface ViewModel : IBase.ViewModel<State> {
    }

    interface State : IBase.State {
    }
}