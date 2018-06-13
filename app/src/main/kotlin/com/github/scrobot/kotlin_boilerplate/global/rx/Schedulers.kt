package com.github.scrobot.kotlin_boilerplate.global.rx

import com.github.scrobot.kotlin_boilerplate.global.di.providers.SchedulersProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers as RxSchedulers
/**
 * Created by alexscrobot on 14.11.17.
 */
object Schedulers: SchedulersProvider {

    override fun ui() = AndroidSchedulers.mainThread()
    override fun computation() = RxSchedulers.computation()
    override fun trampoline() = RxSchedulers.trampoline()
    override fun newThread() = RxSchedulers.newThread()
    override fun io() = RxSchedulers.io()

}