package com.airlift.codingchallenge.base.viewmodel

import android.view.View
import android.widget.AdapterView
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes

/**
 * Created by Tehrim Abbas
 *
 */
abstract class BaseListItemViewModel<ITEM : Any> : BaseViewModel(),
    AdapterView.OnItemClickListener {

    var onChildViewClickListener: ((view: View, position: Int, data: ITEM?) -> Unit)? = null
    abstract fun setItem(item: ITEM, position: Int)
    abstract fun getItem(): ITEM


    @CallSuper
    override fun onCleared() {
        super.onCleared()
    }

    /**
     * It is importance to un-reference activity / fragment instance after they are destroyed
     * For situation of configuration changes, activity / fragment will be destroyed and recreated,
     * but view model will survive, so if we don't un-reference them, memory leaks will occur
     */
    @CallSuper
    open fun onDestroyView() {
    }

    @LayoutRes
    public abstract fun layoutRes(): Int

}