package com.github.scrobot.kotlin_boilerplate.global.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by alexscrobot on 15.11.17.
 */
class ErrorResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val code = response.code()
//        if (code in 400..500) throw ServerError(code)

        return response

    }

    class ServerError(val errorCode: Int) : RuntimeException()
}
