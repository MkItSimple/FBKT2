package com.example.fbkt2.ui

import android.view.View
import com.example.fbkt2.data.Author

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClicked(view: View, author: Author)
}