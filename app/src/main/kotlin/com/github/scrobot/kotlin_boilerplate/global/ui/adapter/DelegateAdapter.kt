package com.github.scrobot.kotlin_boilerplate.global.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import timber.log.Timber
import java.util.*

/**
 * Created by alexscrobot on 28.11.17.
 */
abstract class DelegateAdapter<T, K : AbstractViewHolder<T>>(val layout: Int): RecyclerView.Adapter<K>(), Delegatable {

    private val list: MutableList<T> = ArrayList()

    fun load(list: List<T>?) {
        this.list.clear()
        this.list.addAll(list ?: ArrayList())
        notifyDataSetChanged()
    }

    fun append(list: List<T>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun load(list: T?) {
        if(list is List<*>) {
            this.list.clear()
            this.list.addAll(list as List<T>)
            notifyDataSetChanged()
        }
    }

    fun getItemByPosition(position: Int): T? = try { list[position] } catch (e: IndexOutOfBoundsException) { Timber.e(e); null }

    override fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun deleteAt(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: K, position: Int) {
        holder.attachedAdapter = this
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): K

}