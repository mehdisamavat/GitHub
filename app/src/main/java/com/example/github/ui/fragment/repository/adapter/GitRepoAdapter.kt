package com.example.github.ui.fragment.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.databinding.RvItemRepoBinding
import com.example.github.ui.fragment.repository.RepositoryViewModel

class GitRepoAdapter(
    private val viewModel: RepositoryViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
) : RecyclerView.Adapter<GitRepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        return GitRepoViewHolder(
            RvItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(differ.currentList[position], viewModel, viewLifecycleOwner)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
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