package com.airlift.codingchallenge.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airlift.codingchallenge.base.interfaces.IBase

abstract class BaseViewModelActivity<VS : IBase.State, VM : IBase.ViewModel<VS>>() :
    AppCompatActivity(), IBase.View<VM> {

    /**
     * Indicates whether the current [BaseBindingFragment]'s content view is initialized or not.
     */
    var isViewCreated = false
        private set

    /**
     * Reference to Fragment ViewState
     */
    val viewState: VS
        get() {
            return viewModel.viewState
        }

    //    override val viewModel: Lazy<VM> by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // the overall initialization, extras fetching and post initialization will be performed only once, too

        viewModel.registerLifecycleOwner(this)
    }

    override fun getScreenName(): String = this::class.java.simpleName
}