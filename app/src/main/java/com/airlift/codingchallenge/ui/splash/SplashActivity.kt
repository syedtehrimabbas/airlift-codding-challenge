package com.airlift.codingchallenge.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.airlift.codingchallenge.BR
import com.airlift.codingchallenge.R
import com.airlift.codingchallenge.base.activity.BaseBindingViewModelActivity
import com.airlift.codingchallenge.databinding.ActivitySplashBinding
import com.airlift.codingchallenge.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity :
    BaseBindingViewModelActivity<ActivitySplashBinding, ISplash.State, SplashVM>() {

    override val viewModel: SplashVM by viewModels()
    override val bindingVariableId = BR.viewModel
    override val bindingViewStateVariableId = BR.viewState
    override val layoutResId: Int = R.layout.activity_splash

    override fun onClick(id: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewState.proceedNext.observe(
            this,
            { moveNext() }
        )
    }

    private fun moveNext() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}