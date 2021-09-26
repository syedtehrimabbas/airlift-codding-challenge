package com.airlift.codingchallenge.utils

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar


fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toInvisible() {
    this.visibility = View.GONE
}


/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun View.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).run {
        addCallback(object : Snackbar.Callback() {
            override fun onShown(sb: Snackbar?) {
            }

            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            }
        })
        show()
    }
}

/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */
fun View.setupSnackbar(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<SingleEvent<Any>>,
    timeLength: Int
) {
    snackbarEvent.observe(lifecycleOwner, { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                is String -> {
                    showSnackbar(it, timeLength)
                }
                is Int -> {
                    showSnackbar(this.context.getString(it), timeLength)
                }
                else -> {
                }
            }

        }
    })
}