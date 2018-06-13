package com.github.scrobot.kotlin_boilerplate.global.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.github.scrobot.kotlin_boilerplate.global.ErrorHandler
import com.github.scrobot.kotlin_boilerplate.global.ValidationFailed
import com.github.scrobot.kotlin_boilerplate.global.ValidationStatus
import com.github.scrobot.kotlin_boilerplate.global.ui.holders.ValidationHolder
import timber.log.Timber

/**
 * Created by alexscrobot on 17.03.18.
 */
open class ValidationRxViewModel: RxViewModel() {

    protected val validation = MutableLiveData<ValidationHolder?>()
    protected val showPreloader = MutableLiveData<ValidationStatus?>()

    fun getValidation(): LiveData<ValidationHolder?> {
        validation.value = null

        return validation
    }

    protected open fun validationHandling(it: Throwable) {
        val response = ErrorHandler.getErrorBody(it)
        val validationErrors = mapOf<String, String>() // response?.validationErrors
        Timber.d(response?.toString())
        if (validationErrors.isNotEmpty()) {
            validation.value = ValidationHolder(validationErrors.entries.first().value, validationErrors.keys.toTypedArray())
        } else {
            validation.value = ValidationHolder(response?.throwable?.localizedMessage)
        }

        showPreloader.value = ValidationFailed()
    }

    override fun onCleared() {
        super.onCleared()
        validation.value = null
    }

    fun haveToShowPreloader(): LiveData<ValidationStatus?> {
        showPreloader.value = null

        return showPreloader
    }
}