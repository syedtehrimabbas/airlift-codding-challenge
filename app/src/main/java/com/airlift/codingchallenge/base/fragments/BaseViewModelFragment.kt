package com.airlift.codingchallenge.base.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.airlift.codingchallenge.base.ProgressDialogueFragment
import com.airlift.codingchallenge.base.interfaces.IBase
import com.airlift.codingchallenge.base.state.UIState
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel

abstract class BaseViewModelFragment<VS : IBase.State, VM : IBase.ViewModel<VS>> :
    BaseFragment(), IBase.View<VM> {
    private var progress: ProgressDialogueFragment? = null

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
//        viewModel.value.registerLifecycleOwner(this)
        progress = createProgressDialog()
        setHasOptionsMenu(hasOptionMenu())

        viewState.uiState.observe(this, {

            when (it) {
                is UIState.Loading -> {
                    showLoader(it.isLoading)
                    if (it.message.isNotEmpty()) {
                        showToast(it.message)
                    }
                }
                is UIState.Alert -> {
                    showToast(it.message)
                }
            }
        })
    }

    /**
     * Get reference to Activity ViewModel. Make sure correct VM class is
     * specified.
     */
    inline fun <reified AVM : HiltBaseViewModel<*>> getActivityViewModel(): AVM =
        ViewModelProvider(requireActivity()).get(AVM::class.java)

    fun showLoader(isVisible: Boolean) {
        if (isVisible) {
            if (isResumed && userVisibleHint) {
                if (progress == null) {
                    progress = createProgressDialog()
                    progress?.show(childFragmentManager, progress?.tag)
                } else {
                    progress?.show(childFragmentManager, progress?.tag)
                }
            }
        } else {
            if (progress?.isVisible == true && progress != null)
                progress?.dismiss()
        }
    }

    private fun createProgressDialog(): ProgressDialogueFragment {
        return ProgressDialogueFragment()
    }

    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    override fun getScreenName(): String = this::class.java.simpleName
    override fun hasOptionMenu() = false
}