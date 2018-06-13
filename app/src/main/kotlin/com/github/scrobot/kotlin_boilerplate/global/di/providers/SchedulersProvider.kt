package com.github.scrobot.kotlin_boilerplate.global.di.providers

import io.reactivex.Scheduler

/**
 * Created by alexscrobot on 14.11.17.
 */
interface SchedulersProvider {

    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler

}