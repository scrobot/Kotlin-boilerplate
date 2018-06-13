package com.github.scrobot.kotlin_boilerplate.global.extentions

import android.app.Activity
import android.app.Dialog
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by aleksejskrobot on 24.02.2018.
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun View.vis(expression: () -> Boolean?) {
    this.visibility = if(expression.invoke() == true) View.VISIBLE else View.GONE
}

fun <T: View> View.vis(expression: () -> Boolean?): T {
    vis(expression)

    return this as T
}

fun View.invis(expression: () -> Boolean?) {
    this.visibility = if(expression.invoke() == true) View.INVISIBLE else View.VISIBLE
}

fun <T: View> View.invis(expression: () -> Boolean?): T {
    invis(expression)

    return this as T
}

fun View.disable(predicate: () -> Boolean?) {
    this.isEnabled = predicate.invoke() == false
}

fun <T : View> View.bind(@IdRes res : Int) : Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
}

fun <T : View> Activity.bind(@IdRes res : Int) : Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
}

fun <T : View> Dialog.bind(@IdRes res : Int) : Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
}