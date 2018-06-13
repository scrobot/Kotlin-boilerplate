package com.github.scrobot.kotlin_boilerplate.global.ui.adapter

/**
 * Created by alexscrobot on 23.03.18.
 */
interface Delegatable {

    fun clear()
    fun deleteAt(position: Int)
    fun getItemCount(): Int

}