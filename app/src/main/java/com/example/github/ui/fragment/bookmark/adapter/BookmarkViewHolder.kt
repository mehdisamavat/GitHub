package com.example.github.ui.fragment.bookmark.adapter

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.databinding.RvItemBookmarkBinding
import com.example.github.ui.fragment.bookmark.BookmarkViewModel
import com.example.github.ui.fragment.repository.RepositoryViewModel

class BookmarkViewHolder(private val binding:RvItemBookmarkBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(gitRepo: GitRepo, viewModel: BookmarkViewModel, viewLifecycleOwner: LifecycleOwner) {
        binding.viewModel=viewModel
        binding.lifecycleOwner=viewLifecycleOwner
        binding.gitRepo=gitRepo
        binding.executePendingBindings()
    }



}