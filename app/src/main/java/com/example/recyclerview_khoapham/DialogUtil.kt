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
        fun showAddBookDialog(context: Context, onListenerDialog: OnListenerDialog? = null) {
            Dialog(context).apply {
                setContentView(R.layout.layout_add_book_dialog)

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
                    when {
                        bookName.isBlank() -> edtBookName.error = "Book name cannot be empty"
                        bookPostDate.isBlank() -> edtBookPostDate.error = "Book post date cannot be empty"
                        bookViewCount.isBlank() -> edtBookViewCount.error = "Book view count cannot be empty"
                        bookDescription.isBlank() -> edtBookDescription.error = "Book description cannot be empty"
                        else -> onListenerDialog?.addBook(
                            dialog = this,
                            name = bookName,
                            postDate = bookPostDate,
                            viewCount = bookViewCount,
                            description = bookDescription
                        )
                    }
                }

                show()
            }
        }
    }
}

interface OnListenerDialog {
    fun addBook(
        dialog: Dialog,
        name: String,
        postDate: String,
        viewCount: String,
        description: String
    )
}