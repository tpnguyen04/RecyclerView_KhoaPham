package com.example.recyclerview_khoapham

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import java.util.Date

class DialogUtil {
    companion object {
        fun showAddBookDialog(context: Context, onListenAddBookSuccess: ((String, String, String, String) -> Unit)? = null ) {
            Dialog(context).apply {
                this.setContentView(R.layout.layout_add_book_dialog)

                // set window
                window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

                // find view by id
                val edtBookName = findViewById<EditText>(R.id.edit_text_book_name)
                val edtBookPostDate = findViewById<EditText>(R.id.edit_text_book_post_date)
                val edtBookViewCount = findViewById<EditText>(R.id.edit_text_book_view_count)
                val edtBookDescription = findViewById<EditText>(R.id.edit_text_book_description)
                val btnAddBook = findViewById<AppCompatButton>(R.id.button_add_book)

                btnAddBook.setOnClickListener {
                    val bookName = edtBookName.text.toString()
                    val bookPostDate = edtBookPostDate.text.toString()
                    val bookViewCount = edtBookViewCount.text.toString()
                    val bookDescription = edtBookDescription.text.toString()

                    // set dieu kien de khong empty
                    if (bookName.isBlank()) {
                        edtBookName.error = "Book name cannot be empty"
                    } else if(bookPostDate.isBlank()) {
                        edtBookPostDate.error = ("Book post date cannot be empty")
                    } else if(bookViewCount.isBlank()) {
                        edtBookViewCount.error = ("Book view count cannot be empty")
                    } else if(bookDescription.isBlank()) {
                        edtBookDescription.error = ("Book description cannot be empty")
                    } else {
                        onListenAddBookSuccess?.invoke(bookName, bookPostDate,
                            bookViewCount, bookDescription)
                        this.dismiss()
                        Toast.makeText(context, "Book Adding Successfully", Toast.LENGTH_SHORT).show()
                    }
                }
                // Display dialog
                this.show()

            }

        }
    }
}
//
//interface onListenAddBook {
//    fun addBookSuceess (bookName: String, bookPostDate: String, bookViewCount: Int, bookDescription: String )
//}