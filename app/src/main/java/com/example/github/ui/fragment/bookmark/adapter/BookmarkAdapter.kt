package com.example.github.ui.fragment.bookmark.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.R
import com.example.github.databinding.RvItemBookmarkBinding
import com.example.github.ui.fragment.bookmark.BookmarkViewModel

class BookmarkAdapter(
    private val viewModel: BookmarkViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
) :
    RecyclerView.Adapter<BookmarkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.rv_item_bookmark, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(differ.currentList[position], viewModel, viewLifecycleOwner)

    }

    private val differCallback = object : DiffUtil.ItemCallback<GitRepo>() {
        override fun areItemsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)
}