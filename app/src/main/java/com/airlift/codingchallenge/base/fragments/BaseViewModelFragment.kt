package com.airlift.codingchallenge.base.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.airlift.codingchallenge.base.interfaces.IBase
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel

abstract class BaseViewModelFragment<VS : IBase.State, VM : IBase.ViewModel<VS>> :
    BaseFragment(), IBase.View<VM> {

    /**
     * Indicates whether the current [BaseBindingViewModelFragment]'s content view is initialized or not.
     */
    var isViewCreated = false
        protected set

    /**
     * Reference to Fragment ViewState
     */
    val viewState: VS
        get() {
            return viewModel.viewState
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // the overall initialization, extras fetching and post initialization will be performed only once, too
        if (!isViewCreated) {
            preInit()
        }
        setHasOptionsMenu(hasOptionMenu())
    }

    /**
     * Get reference to Activity ViewModel. Make sure correct VM class is
     * specified.
     */
    inline fun <reified AVM : HiltBaseViewModel<*>> getActivityViewModel(): AVM =
        ViewModelProvider(requireActivity()).get(AVM::class.java)

    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    override fun getScreenName(): String = this::class.java.simpleName
    override fun hasOptionMenu() = false
}