package com.github.scrobot.kotlin_boilerplate.global.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import com.github.scrobot.kotlin_boilerplate.global.Constants
import java.io.IOException

/**
 * Created by aleksejskrobot on 15.07.16.
 */

class HeaderInterceptor(private var token: String?) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest =  request.newBuilder()

        Log.d(TAG, "token: $token")

        if (token != Constants.EMPTY) {
            newRequest.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(newRequest.build())
    }

    companion object {
        private val TAG = HeaderInterceptor::class.java.toString()
    }

}
