package com.github.scrobot.kotlin_boilerplate.global.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

abstract class SearchViewModel: RxViewModel() {

    protected val preloader = MutableLiveData<Boolean>()
    protected val alternativePreloader = MutableLiveData<Boolean>()
    protected val error = MutableLiveData<String>()
    protected val emptyResultsText = MutableLiveData<Boolean>()

    fun getAltPreloader(): LiveData<Boolean> = alternativePreloader

    fun getPreloader(): LiveData<Boolean> = preloader

    fun getErrorMessage(): LiveData<String> = error

    fun observeEmptyResults(): LiveData<Boolean> = emptyResultsText

}