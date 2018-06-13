package com.github.scrobot.kotlin_boilerplate.global

import com.github.scrobot.kotlin_boilerplate.business.entities.ResponseWrapper
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import timber.log.Timber



/**
 * Created by alexscrobot on 12.03.18.
 */
object ErrorHandler {

    fun handle(throwable: Throwable) {
        Timber.e(throwable)
    }

    fun handleCallback(throwable: Throwable, callback: () -> Unit) {
        Timber.e(throwable)
        callback()
    }

    fun getErrorBody(throwable: Throwable): ResponseWrapper<Unit>? {
        handle(throwable)
        return when(throwable) {
            is HttpException -> {
                val error = throwable
                val gson = GsonBuilder().create()
                val errorBody = error.response().errorBody()?.string()
                gson.fromJson<ResponseWrapper<Unit>>(errorBody, object : TypeToken<ResponseWrapper<Unit>>() {}.type)
            }
            else -> ResponseWrapper(500, throwable)
        }
    }

}