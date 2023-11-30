package com.example.recyclerview_khoapham

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
        buttonAddBook = findViewById<AppCompatButton>(R.id.button_add_book)
        buttonAddBook.setOnClickListener {
//
            DialogUtil?.showAddBookDialog(this@MainActivity) {bookName, bookPostDate, bookViewCount, bookDescription ->
                val postDate = DateUtil.convertDateToMillisecond(bookPostDate)
                val newBook = Book(
                R.drawable.image_default,
                bookName, Date(bookPostDate), bookViewCount.toInt(),
                bookDescription)
                listBook.add(newBook)
                bookAdapter.notifyItemInserted(listBook.size - 1)
            }
        }

        // sort item trong recyclerView
        spinnerSortBook = findViewById(R.id.spinner_sort_book)
        spinnerSortBook.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> listBook.sortBy { it.postDate }
                    1 -> listBook.sortBy { it.viewCount }
                    else -> listBook.sortBy { it.name }
                }
                bookAdapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }


//        val date2011 = convertDateToMillisecond("20/11/2023")
//        val date1311 = convertDateToMillisecond("13/11/2023")
//        val date0911 = convertDateToMillisecond("09/11/2023 ")
//        val date1306 = convertDateToMillisecond("13/06/2023")
//        val date0301 = convertDateToMillisecond("03/01/2023")
//        val date1101 = convertDateToMillisecond("11/01/2023")
//
//        Log.d("pphat", date2011.toString())
//        Log.d("pphat", date1311.toString())
//        Log.d("pphat", date0911.toString())
//        Log.d("pphat", date1306.toString())
//        Log.d("pphat", date0301.toString())
//        Log.d("pphat", date1101.toString())

        // ví dụ set span để sử lí onClick cho text
//        findViewById<TextView>(R.id.text_view_test)?.let {
//            val spannableStringBuilder = SpannableStringBuilder().apply {
//                append("Lượt xem: abc")
//            }
//
//            spannableStringBuilder.setSpan(object : ClickableSpan() {
//                override fun onClick(p0: View) {
//                    Toast.makeText(this@MainActivity, "Click text", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun updateDrawState(ds: TextPaint) {
//                    ds.color = resources.getColor(R.color.black)
//                }
//            }, 0, spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//            it.movementMethod = LinkMovementMethod.getInstance()
//            it.text = spannableStringBuilder
//        }
    }

