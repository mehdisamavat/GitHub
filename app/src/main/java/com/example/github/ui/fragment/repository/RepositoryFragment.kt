package com.example.github.ui.fragment.repository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.R
import com.example.github.databinding.FragmentRepositoryBinding
import com.example.github.ui.fragment.profile.ProfileFragment
import com.example.github.ui.fragment.repository.adapter.GitRepoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryFragment : Fragment() {

    private lateinit var binding:FragmentRepositoryBinding
    private  val viewModel: RepositoryViewModel by viewModels()
    private lateinit var gitRepoAdapter: GitRepoAdapter
    var items: ArrayList<GitRepo> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_repository,container,false)
        viewModel.getGitRep("mehdisamavat")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gitRepoAdapter = GitRepoAdapter(items)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.rvGitRepo.apply {
            adapter = gitRepoAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        viewModel.gitRepo.observe(viewLifecycleOwner){list->
            items.addAll(list)
            gitRepoAdapter.notifyDataSetChanged()
        }

        viewModel.stateResponse.observe(viewLifecycleOwner){
            Toast.makeText(requireActivity(),it, Toast.LENGTH_SHORT).show()
        }

    }
    companion object {
        fun newInstance() = RepositoryFragment()
    }

}