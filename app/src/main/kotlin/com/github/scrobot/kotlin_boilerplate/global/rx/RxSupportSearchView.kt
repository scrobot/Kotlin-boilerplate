package com.github.scrobot.kotlin_boilerplate.global.rx

import android.support.v7.widget.SearchView
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe

/**
 * Created by alexscrobot on 23.11.17.
 */
object RxSupportSearchView {

    fun with(view: SearchView) = Flowable.create(FlowableOnSubscribe<String> {
        var listener: SearchView.OnQueryTextListener? = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                it.onNext(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                it.onNext(newText)
                return false
            }
        }

        view.setOnQueryTextListener(listener)

    }, BackpressureStrategy.BUFFER)

}