package com.github.scrobot.kotlin_boilerplate.global.viewmodels

import android.arch.lifecycle.ViewModel
import com.github.scrobot.kotlin_boilerplate.global.contracts.OnBackPressedable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by alexscrobot on 20.11.17.
 */
open class RxViewModel: ViewModel(), OnBackPressedable {

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun addDispose(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun unsubscribe() {
        compositeDisposable.dispose()
    }

    override fun onCleared() {
        super.onCleared()
        unsubscribe()
    }

    override fun onBackPressed() {}
}