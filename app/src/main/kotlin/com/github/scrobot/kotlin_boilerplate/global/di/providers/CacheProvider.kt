package com.github.scrobot.kotlin_boilerplate.global.di.providers

import com.github.scrobot.kotlin_boilerplate.global.Constants
import com.github.scrobot.kotlin_boilerplate.global.di.holders.CacheHolder
import java.io.File

/**
 * Created by aleksejskrobot on 24.12.2017.
 */
object CacheProvider {

    private val holder: CacheHolder

    init {
        val cacheSize = Constants.CACHE_SIZE
        val file = File(Constants.CACHE)
        holder = CacheHolder(cacheSize, file)
    }

    fun get() = holder
}