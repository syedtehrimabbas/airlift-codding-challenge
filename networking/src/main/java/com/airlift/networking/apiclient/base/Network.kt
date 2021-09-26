package com.airlift.networking.apiclient.base

import android.app.Application
import okhttp3.Interceptor

internal interface Network {
    fun initWith(application: Application, baseUrl: String)
    fun initWith(application: Application, baseUrl: String, interceptor: Interceptor)
    fun <T> createService(serviceInterface: Class<T>): T
}