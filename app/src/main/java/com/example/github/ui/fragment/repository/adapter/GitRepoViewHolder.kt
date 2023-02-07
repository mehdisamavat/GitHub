package com.example.github.ui.fragment.repository.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.databinding.RvItemGitRepoBinding

class GitRepoViewHolder(private var binding: RvItemGitRepoBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(gitRepo: GitRepo) {
        binding.gitRepo=gitRepo
        binding.executePendingBindings()
    }

}