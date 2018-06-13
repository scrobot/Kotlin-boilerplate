package com.github.scrobot.kotlin_boilerplate.global.di.modules

import android.content.Context
import android.content.res.Resources
import com.google.gson.GsonBuilder
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import com.github.scrobot.kotlin_boilerplate.global.preferences.IPreferences
import com.github.scrobot.kotlin_boilerplate.global.preferences.PreferenceManager
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

/**
 * Created by alexscrobot on 14.11.17.
 */
object AppModule {

    private val cicerone = Cicerone.create()
    val beans = applicationContext {

        bean { this@applicationContext }.bind(Context::class)
        bean { androidApplication().resources }.bind(Resources::class)
        bean { GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create() }
        bean { PreferenceManager(androidApplication().applicationContext) as IPreferences }
        bean { CompositeDisposable() }
        bean { cicerone.router as Router }
        bean { cicerone.navigatorHolder as NavigatorHolder }

    }

}