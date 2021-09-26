package com.airlift.networking.apiclient.base

import retrofit2.Response

internal interface IRepository {
    suspend fun <T : ApiResponse> executeSafely(call: suspend () -> Response<T>): RetroApiResponse<T>
}