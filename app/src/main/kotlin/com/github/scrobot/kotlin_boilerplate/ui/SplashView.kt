package com.github.scrobot.kotlin_boilerplate.ui

import android.os.Bundle
import com.github.scrobot.kotlin_boilerplate.R
import com.github.scrobot.kotlin_boilerplate.global.Views
import com.github.scrobot.kotlin_boilerplate.global.ui.BaseFragment
import com.github.scrobot.kotlin_boilerplate.ui.loader.LoaderView
import timber.log.Timber


/**
 * Created by aleksejskrobot on 24.02.2018.
 */
class SplashView: BaseFragment() {
    override val layout = R.layout.splash_view
    override val navigationId = Views.SPLASH_VIEW

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        if(savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                    .add(R.id.fragment, LoaderView())
                    .commitNow()
        } else {
            Timber.d("savedInstanceState -> $savedInstanceState")
        }
    }

    fun getCurrentChildFragment(): BaseFragment? {
        return childFragmentManager.findFragmentById(R.id.fragment) as BaseFragment
    }
}