package com.github.scrobot.kotlin_boilerplate.global.extentions

import com.github.scrobot.kotlin_boilerplate.global.rx.Schedulers
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by alexscrobot on 27.11.17.
 */
fun<T> Observable<T>.ui() =
        this
                .observeOn(Schedulers.ui())
                .subscribeOn(Schedulers.io())

fun<T> Observable<T>.newThread() =
        this
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())

fun<T> Observable<T>.computation() =
        this
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())

fun<T> Single<T>.ui() =
        this
                .observeOn(Schedulers.ui())
                .subscribeOn(Schedulers.io())

fun<T> Single<T>.newThread() =
        this
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())

fun<T> Single<T>.computation() =
        this
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())

fun<T> Flowable<T>.ui() =
        this
                .observeOn(Schedulers.ui())
                .subscribeOn(Schedulers.io())

fun<T> Flowable<T>.newThread() =
        this
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())

fun<T> Flowable<T>.computation() =
        this
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())

fun<T> Flowable<T>.backpressurePolicy() =
        this.onBackpressureBuffer()

fun<T> Observable<T>.trampoline() =
        this
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

fun<T> Single<T>.trampoline() =
        this
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

fun<T> Flowable<T>.trampoline() =
        this
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

fun Completable.ui() =
        this
                .observeOn(Schedulers.ui())
                .subscribeOn(Schedulers.io())

fun Completable.newThread() =
        this
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())

fun Completable.computation() =
        this
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())
