package com.airlift.codingchallenge.base.interfaces

import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData

interface IBase {
    interface View<VM : ViewModel<*>> {
        val viewModel: VM
        /**MV
         * Override for set binding variable
         *
         * @return variable id
         */
        /**
         * Field which holds BR.viewModel identifier generated by Data Binding framework. This field should
         * be specified only once in your project's BaseFragment.
         */
        val bindingVariableId: Int

        /**
         * Field which holds BR.viewState identifier generated by Data Binding framework. This field should
         * be specified only once in your project's BaseFragment.
         */
        val bindingViewStateVariableId: Int

        /**
         * @return layout resource id
         */

        val layoutResId: Int

        //        fun showLoader(isVisible: Boolean)
        fun showToast(msg: String)

        //        fun showInternetSnack(isVisible: Boolean)
//        fun isPermissionGranted(permission: String): Boolean
//        fun requestPermissions()
//        fun getString(resourceKey: String): String
        fun performDataBinding(savedInstanceState: Bundle?)

        //        var shouldRegisterViewModelLifeCycle: Boolean
        fun getScreenName(): String?

    }

    interface ViewModel<VS : State> : ILifecycle {
        val viewState: VS
    }

    interface State : LifecycleObserver {
        var toolbarTitle: MutableLiveData<String>
        var toolsBarVisibility: MutableLiveData<Boolean>
        fun onStart()
        fun onStop()
        fun destroy()
        fun onCreate()
        fun resume()
        fun pause()
    }
}
