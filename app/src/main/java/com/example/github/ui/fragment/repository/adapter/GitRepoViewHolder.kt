package com.example.github.ui.fragment.repository.adapter

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.databinding.RvItemRepoBinding
import com.example.github.ui.fragment.repository.RepositoryViewModel

class GitRepoViewHolder(private var binding: RvItemRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(gitRepo: GitRepo, viewModel: RepositoryViewModel, viewLifecycleOwner: LifecycleOwner) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.gitRepo = gitRepo
        binding.executePendingBindings()
    }

}