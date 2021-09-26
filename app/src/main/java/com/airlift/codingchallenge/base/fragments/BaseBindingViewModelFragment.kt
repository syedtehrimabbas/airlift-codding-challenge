package com.airlift.codingchallenge.base.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.airlift.codingchallenge.base.interfaces.CanHandleOnClick
import com.airlift.codingchallenge.base.interfaces.IBase
import com.airlift.codingchallenge.base.interfaces.OnClickHandler
import com.airlift.codingchallenge.base.viewmodel.HiltBaseViewModel

abstract class BaseBindingViewModelFragment<VB : ViewDataBinding, VS : IBase.State, VM : HiltBaseViewModel<VS>> :
    BaseViewModelFragment<VS, VM>(), CanHandleOnClick {

    lateinit var mViewDataBinding: VB
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setupBindingView(inflater, container, layoutResId) {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val wasViewCreated = isViewCreated
        isViewCreated = true

        // performing the initialization only in cases when the view was created for the first time
        if (!wasViewCreated) {
            init(savedInstanceState)
            postInit()
        }
        performDataBinding(savedInstanceState)

    }

    override fun performDataBinding(savedInstanceState: Bundle?) {
        registerStateListeners()
        //viewModel.c = requireContext()
        if (bindingViewStateVariableId <= 0)
            throw IllegalArgumentException("The state  binding variable should not null or zero. Check your fragment ${javaClass.simpleName}. Fragment should override bindingViewStateVariableId and provide valid binding variable for state ")
        mViewDataBinding.setVariable(bindingViewStateVariableId, viewModel.viewState)
        if (bindingVariableId <= 0)
            throw IllegalArgumentException("The state  binding variable should not null or zero. Check your fragment ${javaClass.simpleName}. Fragment should override bindingVariableId and provide valid binding variable for viewModel")
        mViewDataBinding.setVariable(bindingVariableId, viewModel)
        mViewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        mViewDataBinding.executePendingBindings()

        if (viewModel is OnClickHandler) {
            viewModel.clickEvent?.observe(viewLifecycleOwner, { onClick(it) })
        }
        postExecutePendingBindings(savedInstanceState)
        viewModel.onCreate(arguments)
    }

    private fun setupBindingView(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        layoutResId: Int,
        set: (VB) -> Unit
    ): View {
        mViewDataBinding =
            DataBindingUtil.inflate<VB>(layoutInflater, layoutResId, container, false).also {
                set(it)
            }
        return mViewDataBinding.root
    }

    private fun registerStateListeners() {
        viewModel.registerLifecycleOwner(this)
    }

    private fun unregisterStateListeners() {
        viewModel.unregisterLifecycleOwner(this)
    }

    override fun onDestroyView() {
        unregisterStateListeners()
        super.onDestroyView()
    }
}
