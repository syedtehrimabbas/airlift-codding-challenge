package com.airlift.codingchallenge.base.activity

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.airlift.codingchallenge.base.interfaces.CanHandleOnClick
import com.airlift.codingchallenge.base.interfaces.IBase
import com.airlift.codingchallenge.base.interfaces.OnClickHandler
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel

abstract class BaseBindingViewModelActivity<VB : ViewDataBinding, VS : IBase.State, VM : HiltBaseViewModel<VS>> :
    BaseViewModelActivity<VS, VM>(), CanHandleOnClick {

    lateinit var mViewDataBinding: VB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindingView(this, layoutResId) {
            mViewDataBinding = it
            performDataBinding(savedInstanceState)
        }
    }

    private fun setupBindingView(
        fragmentActivity: FragmentActivity,
        layoutResId: Int,
        set: (VB) -> Unit
    ): VB {
        return DataBindingUtil.setContentView<VB>(fragmentActivity, layoutResId).also {
            set(it)
        }
    }

    override fun performDataBinding(savedInstanceState: Bundle?) {

        registerStateListeners()
        if (bindingViewStateVariableId <= 0)
            throw IllegalArgumentException("The state  binding variable should not null or zero. Check your activity. Activity should override bindingViewStateVariableId and provide valid binding variable for state ")
        mViewDataBinding.setVariable(bindingViewStateVariableId, viewModel.viewState)
        if (bindingVariableId <= 0)
            throw IllegalArgumentException("The state  binding variable should not null or zero. Check your activity. Activity should override bindingVariableId and provide valid binding variable for viewModel")
        mViewDataBinding.setVariable(bindingVariableId, viewModel)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()

        if (viewModel is OnClickHandler) {
            viewModel.clickEvent?.observe(this, { onClick(it) })
        }
        viewModel.onCreate(intent.extras)
    }

    private fun registerStateListeners() {
        if (viewModel is HiltBaseViewModel<*>) {
            viewModel.registerLifecycleOwner(this)
        }
    }

    private fun unregisterStateListeners() {
        if (viewModel is HiltBaseViewModel<*>) {
            viewModel.unregisterLifecycleOwner(this)
        }
    }

    override fun onDestroy() {
        unregisterStateListeners()
        super.onDestroy()
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
