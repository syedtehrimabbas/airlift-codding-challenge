package com.airlift.codingchallenge.ui.splash

import androidx.lifecycle.MutableLiveData
import com.airlift.codingchallenge.ui.splash.ISplash
import com.airlift.codingchallenge.base.state.BaseState
import javax.inject.Inject

class SplashState @Inject constructor() : BaseState(), ISplash.State {
    override var proceedNext: MutableLiveData<Boolean> = MutableLiveData(false)
}