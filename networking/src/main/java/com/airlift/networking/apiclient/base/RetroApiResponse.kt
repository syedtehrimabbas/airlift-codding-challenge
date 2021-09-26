package com.airlift.networking.apiclient.base

import com.airlift.networking.apiclient.base.error.ApiError

sealed class RetroApiResponse<out T : ApiResponse> {
    data class Success<out T : ApiResponse>(val code: Int, val data: T) : RetroApiResponse<T>()
    data class Error(val error: ApiError) : RetroApiResponse<Nothing>()
}