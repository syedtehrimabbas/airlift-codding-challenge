package com.airlift.networking.authentication.responsedtos

import com.airlift.networking.apiclient.base.ApiResponse


/**

Created by Tehrim Abbas on 26/09/2021.

 **/

data class CoinlayerResponse(
    val privacy: String,
    val rates: HashMap<String, String>,
    val success: Boolean,
    val target: String,
    val terms: String,
    val timestamp: Int
) : ApiResponse()