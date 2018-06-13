package com.github.scrobot.kotlin_boilerplate.global.di.providers

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alexscrobot on 15.11.17.
 */
class BackendApiProvider<T>(
        private val okHttpClient: OkHttpClient,
        private val gson: Gson,
        private val serverPath: String,
        val api: Class<T>
) {

    fun get() =
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(serverPath)
                    .build()
                    .create(api)
}