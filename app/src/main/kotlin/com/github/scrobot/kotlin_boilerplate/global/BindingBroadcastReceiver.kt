package com.github.scrobot.kotlin_boilerplate.global

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.github.scrobot.kotlin_boilerplate.global.viewmodels.BroadcastViewModel

abstract class BindingBroadcastReceiver<T: BroadcastViewModel>: BroadcastReceiver() {

    private var viewModel: T? = null

    fun bindViewModel(viewModel: T) {
        this.viewModel = viewModel
    }

    fun unbindViewModel() {
        this.viewModel = null
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        viewModel?.receive(intent)
    }

}