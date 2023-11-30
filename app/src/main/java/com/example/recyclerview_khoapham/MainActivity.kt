package com.example.recyclerview_khoapham

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_khoapham.DateUtil.Companion.convertDateToMillisecond
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var buttonAddBook: Button
    private lateinit var spinnerSortBook: Spinner
    private var listBook: MutableList<Book> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // anh xa recyclerview tu xml vao bien recyclerView
        recyclerView = findViewById(R.id.recyclerview_book)
        buttonAddBook = findViewById<AppCompatButton>(R.id.button_add_book)
        spinnerSortBook = findViewById(R.id.spinner_sort_book)
        // tạo biến bookAdapter từ class BookAdapter.kt
        bookAdapter = BookAdapter()

        // get list book, lấy data book từ class Book.kt
        listBook = Book.getListBooks().toMutableList()
        // set list book data cho adapter
        bookAdapter.setListBook(listBook)
        // set adapter cho RecyclerView
        recyclerView.adapter = bookAdapter

        // remove item from list
        bookAdapter.setOnLongClickListener { position ->
            listBook.removeAt(position)
            bookAdapter.notifyItemRemoved(position)
        }

        // add item vào recyclerview
        buttonAddBook.setOnClickListener {
            DialogUtil.showAddBookDialog(this@MainActivity, onListenerDialog)
        }

        // sort item trong recyclerView
        spinnerSortBook.onItemSelectedListener = onListenSortItem
    }

    private val onListenSortItem = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
            when (position) {
                0 -> listBook.sortByDescending { it.postDate }
                1 -> listBook.sortByDescending { it.viewCount }
                else -> listBook.sortBy { it.name }
            }
            bookAdapter.notifyItemRangeChanged(0, bookAdapter.getListBook().size - 1)
        }

        override fun onNothingSelected(p0: AdapterView<*>?) { }
    }

    private val onListenerDialog = object : OnListenerDialog{
        override fun addBook(
            dialog: Dialog,
            name: String,
            postDate: String,
            viewCount: String,
            description: String
        ) {
            listBook.add(Book(
                image = R.drawable.image_default,
                name = name,
                postDate = DateUtil.getCurrentDate(),
                viewCount = 0,
                description = description
            ))
            bookAdapter.notifyItemInserted(listBook.size - 1)
            dialog.dismiss()
        }
    }
}

