package com.airlift.codingchallenge.ui.main

import android.os.Bundle
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    override val viewState: MainState,
) :
    HiltBaseViewModel<IMainActivity.State>(), IMainActivity.ViewModel {
    override fun handleOnClick(id: Int) {
    }

    override fun onFirsTimeUiCreate(bundle: Bundle?) {
    }

}