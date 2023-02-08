package com.example.github.ui.fragment.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.github.R
import com.example.github.databinding.FragmentRepositoryBinding
import com.example.github.ui.fragment.repository.adapter.GitRepoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryFragment : Fragment() {

    private lateinit var binding: FragmentRepositoryBinding
    private val viewModel: RepositoryViewModel by viewModels()
    private lateinit var gitRepoAdapter: GitRepoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_repository, container, false)
        viewModel.getGitRep(getString(R.string.default_user_name))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gitRepoAdapter = GitRepoAdapter(viewModel, viewLifecycleOwner)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvGitRepo.apply {
            adapter = gitRepoAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        viewModel.allRepo.observe(viewLifecycleOwner) {
            gitRepoAdapter.differ.submitList(it)
        }

    }

    companion object {
        fun newInstance() = RepositoryFragment()
    }

}