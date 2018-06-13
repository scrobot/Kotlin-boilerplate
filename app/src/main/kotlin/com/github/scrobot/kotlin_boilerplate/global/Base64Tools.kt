package com.github.scrobot.kotlin_boilerplate.global

import android.util.Base64

/**
 * Created by alexscrobot on 14.11.17.
 */
object Base64Tools {

    fun decode(input: String) = String(Base64.decode(input.toByteArray(), Base64.DEFAULT))
    fun encode(input: String) = String(Base64.encode(input.toByteArray(), Base64.DEFAULT))

}