package com.github.scrobot.kotlin_boilerplate.global.di.modules

import com.github.scrobot.kotlin_boilerplate.global.BackendApi
import com.github.scrobot.kotlin_boilerplate.global.Constants
import com.github.scrobot.kotlin_boilerplate.global.di.holders.CacheHolder
import com.github.scrobot.kotlin_boilerplate.global.di.providers.BackendApiProvider
import com.github.scrobot.kotlin_boilerplate.global.di.providers.CacheProvider
import com.github.scrobot.kotlin_boilerplate.global.di.providers.OkHttpProvider
import okhttp3.OkHttpClient
import org.koin.dsl.module.applicationContext

/**
 * Created by alexscrobot on 15.11.17.
 */
object NetworkModule {

    val beans = applicationContext {
        bean { CacheProvider.get() }.bind(CacheHolder::class)
        factory { OkHttpProvider(get(), get()).get() }.bind(OkHttpClient::class)
        factory { BackendApiProvider(get(), get(), Constants.URL, BackendApi::class.java).get() }.bind(BackendApi::class)
    }

}