package com.hackerton.jureumuing.config

import com.hackerton.jureumuing.utils.SharedPreferencesManager
import com.hackerton.jureumuing.utils.SharedPreferencesManager.Companion.X_ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthorizationTokenInterceptor @Inject constructor(
    private val sharedPreferencesManager: SharedPreferencesManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        sharedPreferencesManager.getJwt()?.let { builder.addHeader(X_ACCESS_TOKEN, it) }

        return chain.proceed(builder.build())
    }
}