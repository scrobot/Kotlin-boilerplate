package com.github.scrobot.kotlin_boilerplate.global.di.modules

import com.github.scrobot.kotlin_boilerplate.business.chars.CharsIntercatorImpl
import com.github.scrobot.kotlin_boilerplate.business.chars.contracts.CharacterInteractor
import org.koin.dsl.module.applicationContext

object BusinessLayerModule {

    val beans = applicationContext {
        bean { CharsIntercatorImpl(get()) as CharacterInteractor }
    }

}