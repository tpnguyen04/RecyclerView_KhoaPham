package com.example.recyclerview_khoapham

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var listBook: List<Book> = emptyList()
    private var onLongClickListener: ((Int) -> Unit)? = null
    fun setListBook(listBook: List<Book>) {
        this.listBook = listBook
    }

    fun getListBook(): List<Book> = listBook

    inner class BookViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var image: ImageView = view.findViewById(R.id.image_view_book)
        private var tvName: TextView = view.findViewById(R.id.text_view_book_name)
        private var tvPostDateAndViewCount: TextView = view.findViewById(R.id.text_view_book_post_date_and_view_count)
        private var tvDescription: TextView = view.findViewById(R.id.text_view_book_description)

        init {
            view.setOnLongClickListener {
                // invoke dùng để check null
                onLongClickListener?.invoke(adapterPosition)
                // hàm setOnLongClickListener cần trả về 1 giá trị Boolean
                return@setOnLongClickListener true
            }
        }

        fun bind(book: Book?) {
            book?.let {
                image.setImageResource(it.image)
                tvName.text = it.name
                tvPostDateAndViewCount.text = SpannableStringBuilder().apply {
                    append("Ngày đăng ${DateUtil.convertMilliSecondToString(it.postDate.time)}")
                    append(" - ")
                    append("Lượt xem: ${it.viewCount}", )
                }
                tvDescription.text = it.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        // layout inflater chuyển đổi file xml sang view
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(listBook.getOrNull(position))
    }

    fun setOnLongClickListener(onLongClickListener: (Int) -> Unit) {
        this.onLongClickListener = onLongClickListener
    }
}