package com.airlift.codingchallenge.ui.main

import androidx.activity.viewModels
import com.airlift.codingchallenge.BR
import com.airlift.codingchallenge.R
import com.airlift.codingchallenge.base.activity.BaseBindingViewModelActivity
import com.airlift.codingchallenge.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    BaseBindingViewModelActivity<ActivitySplashBinding, IMainActivity.State, MainVM>() {

    override val viewModel: MainVM by viewModels()
    override val bindingVariableId = BR.viewModel
    override val bindingViewStateVariableId = BR.viewState
    override val layoutResId: Int = R.layout.activity_main

    override fun onClick(id: Int) {
    }
}