package com.airlift.codingchallenge.base.interfaces

import com.airlift.codingchallenge.base.clickevents.SingleClickEvent

interface OnClickHandler {
    val clickEvent: SingleClickEvent?
    fun handlePressOnView(id: Int)
}