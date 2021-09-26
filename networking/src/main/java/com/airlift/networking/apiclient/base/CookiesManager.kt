package com.airlift.networking.apiclient.base

import java.util.*

object CookiesManager {
    var jwtToken: String? = null
    var isLoggedIn: Boolean = false
    var cookieSet: HashSet<String> = HashSet()
}