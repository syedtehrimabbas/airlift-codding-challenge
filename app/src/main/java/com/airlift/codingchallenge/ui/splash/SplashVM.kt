package com.airlift.codingchallenge.ui.splash

import android.os.Bundle
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    override val viewState: SplashState,
) :
    HiltBaseViewModel<ISplash.State>(), ISplash.ViewModel {
    override fun handleOnClick(id: Int) {
    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
        launch {
            delay(2000)
            viewState.proceedNext.postValue(true)
        }
    }

}