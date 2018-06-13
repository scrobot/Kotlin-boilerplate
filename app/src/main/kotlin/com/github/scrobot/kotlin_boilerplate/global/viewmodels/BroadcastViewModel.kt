package com.github.scrobot.kotlin_boilerplate.global.viewmodels

import android.content.Intent

abstract class BroadcastViewModel: RxViewModel() {

    abstract fun receive(intent: Intent?)

}