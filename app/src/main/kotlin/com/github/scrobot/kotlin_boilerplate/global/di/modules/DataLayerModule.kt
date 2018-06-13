package com.github.scrobot.kotlin_boilerplate.global.di.modules

import com.github.scrobot.kotlin_boilerplate.chars.CharactersRepositoryImpl
import com.github.scrobot.kotlin_boilerplate.chars.contracts.CharactersRepository
import org.koin.dsl.module.applicationContext

/**
 * Created by alexscrobot on 15.12.17.
 */
object DataLayerModule {

    val beans = applicationContext {

        bean { CharactersRepositoryImpl(get()) as CharactersRepository }

    }

}