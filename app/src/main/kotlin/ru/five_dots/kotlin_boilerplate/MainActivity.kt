package com.github.scrobot.kotlin_boilerplate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import ru.five_dots.kotlin_boilerplate.Repository
import ru.five_dots.kotlin_boilerplate.util.BooksAdapter

class MainActivity : AppCompatActivity() {

    val adapter: BooksAdapter = BooksAdapter()
    val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        books.layoutManager = LinearLayoutManager(this)
        books.adapter = adapter

        loadBooks()
    }

    private fun loadBooks() {
        repository.loadPerPage(1)?.subscribe{
            adapter.addBooks(it)
        }
    }
}
