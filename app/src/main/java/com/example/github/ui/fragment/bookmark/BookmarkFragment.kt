package com.example.github.ui.fragment.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.GitRepo
import com.example.github.R
import com.example.github.databinding.FragmentBookmarkBinding
import com.example.github.ui.fragment.bookmark.adapter.BookmarkAdapter
import com.example.github.ui.fragment.repository.adapter.GitRepoAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BookmarkFragment : Fragment() {

    private  val viewModel: BookmarkViewModel by viewModels()
    private lateinit var binding:FragmentBookmarkBinding
    private lateinit var bookmarkAdapter: BookmarkAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_bookmark,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookmarkAdapter = BookmarkAdapter(viewModel,viewLifecycleOwner )

        binding.rvBookmark.apply {
            adapter = bookmarkAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        viewModel.bookMarkRepo.observe(viewLifecycleOwner) {
            bookmarkAdapter.differ.submitList(it)
        }
    }

}