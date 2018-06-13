package com.github.scrobot.kotlin_boilerplate.global.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by alexscrobot on 28.11.17.
 */
abstract class AbstractViewHolder<in T>(
        private val view: View,
        private val context: Context
): RecyclerView.ViewHolder(view) {

    var attachedAdapter: Delegatable? = null

    abstract fun bind(holder: T)

}