package com.github.scrobot.kotlin_boilerplate

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.github.scrobot.kotlin_boilerplate.global.di.modules.*
import com.squareup.leakcanary.LeakCanary
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class RickAndMortyApp: MultiDexApplication() {

    companion object {
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        LeakCanary.install(this)

        context = applicationContext

        JodaTimeAndroid.init(this)

        initLogger()
        initDI()
    }

    private fun initLogger() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initDI() {
        startKoin(this, listOf(AppModule.beans, ViewModelModule.beans, BusinessLayerModule.beans, DataLayerModule.beans, NetworkModule.beans))
    }

    /*inner class CrashlyticsTree : Timber.Tree() {

        private val CRASHLYTICS_KEY_PRIORITY = "priority"
        private val CRASHLYTICS_KEY_TAG = "tag"
        private val CRASHLYTICS_KEY_MESSAGE = "message"

        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
                return
            }

            Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority)
            Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag)
            Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message)

            if (t == null) {
                Crashlytics.logException(Exception(message))
            } else {
                Crashlytics.logException(t)
            }
        }

    }*/
}