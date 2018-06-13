package com.github.scrobot.kotlin_boilerplate.global.di.holders

import okhttp3.Cache
import java.io.File

/**
 * Created by aleksejskrobot on 24.12.2017.
 */
class CacheHolder(size: Long, directory: File) {

    val okHttpCache = Cache(directory, size)

}