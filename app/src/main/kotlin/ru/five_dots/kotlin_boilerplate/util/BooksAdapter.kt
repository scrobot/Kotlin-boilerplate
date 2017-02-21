package ru.five_dots.kotlin_boilerplate.util

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.scrobot.kotlin_boilerplate.R
import ru.five_dots.kotlin_boilerplate.network.Book
import java.util.*

/**
 * Created by aleksejskrobot on 21.02.17.
 */
class BooksAdapter : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    val books: MutableList<Book> = ArrayList()

    fun addBooks(books: List<Book>) {
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val book = books[position]

        holder?.name?.text = book.name
        holder?.url?.text = book.url
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_item, null), parent?.context)
    }

    override fun getItemCount(): Int {
        return books.size
    }


    class ViewHolder(itemView: View, context: Context?): RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.name) as TextView
        val url: TextView = itemView.findViewById(R.id.url) as TextView

    }
}