package com.github.scrobot.kotlin_boilerplate.global.di.providers

import android.support.multidex.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.github.scrobot.kotlin_boilerplate.global.di.holders.CacheHolder
import com.github.scrobot.kotlin_boilerplate.global.interceptors.CurlLoggingInterceptor
import com.github.scrobot.kotlin_boilerplate.global.interceptors.ErrorResponseInterceptor
import com.github.scrobot.kotlin_boilerplate.global.interceptors.HeaderInterceptor
import com.github.scrobot.kotlin_boilerplate.global.preferences.IPreferences
import java.util.concurrent.TimeUnit

/**
 * Created by alexscrobot on 15.11.17.
 */
class OkHttpProvider(private val cacheHolder: CacheHolder, private val prefs: IPreferences) {

    fun get(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder
                .addNetworkInterceptor(ErrorResponseInterceptor())
                .addNetworkInterceptor(HeaderInterceptor(/*prefs.getAuthToken()*/ null))
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(cacheHolder.okHttpCache)

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addNetworkInterceptor(httpLoggingInterceptor)
            builder.addNetworkInterceptor(CurlLoggingInterceptor())
        }

        return builder.build()
    }
}
