package com.example.fbkt2.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fbkt2.R
import com.example.fbkt2.data.Author
import kotlinx.android.synthetic.main.recycler_view_author.view.*

class AuthorsAdapter : RecyclerView.Adapter<AuthorsAdapter.AuthorViewModel>() {

    private var authors = mutableListOf<Author>()
    var listener: RecyclerViewClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AuthorViewModel(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_author, parent, false)
    )

    override fun getItemCount() = authors.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AuthorViewModel, position: Int) {
        holder.view.text_view_name.text = authors[position].name
        holder.view.button_edit.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, authors[position])
        }
        holder.view.button_delete.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, authors[position])
        }
    }

    fun setAuthors(authors: List<Author>) {
        this.authors = authors as MutableList<Author>
        notifyDataSetChanged()
    }

    class AuthorViewModel(val view: View) : RecyclerView.ViewHolder(view)
}