package com.example.github.ui.fragment.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.databinding.RvItemGitRepoBinding

class GitRepoAdapter(private val items:List<GitRepo>):RecyclerView.Adapter<GitRepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
       return GitRepoViewHolder(RvItemGitRepoBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
      holder.bind(items[position])
    }
    override fun getItemCount(): Int {
        return items.size
    }

}