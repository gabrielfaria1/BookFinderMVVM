package com.example.bookfinder.presentation.ui.book_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bookfinder.R
import com.example.bookfinder.domain.model.Book
import com.example.bookfinder.databinding.ListItemBinding


class BookListAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {

    override fun getItemCount() = books.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    inner class BookViewHolder(val listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root)


    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.listItemBinding.book = books[position]
        holder.listItemBinding.executePendingBindings()

        holder.listItemBinding.listItemLayout.setOnClickListener {
            val action =
                BookListFragmentDirections.actionHomeFragmentToBookDetailsFragment(books[position])
            it.findNavController().navigate(action)
        }
    }
}


