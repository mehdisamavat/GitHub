package com.example.github.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.github.R
import com.example.github.databinding.FragmentGitHubBinding
import com.example.github.ui.fragment.adapter.GitHubViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class GitHubFragment : Fragment() {


    private lateinit var binding: FragmentGitHubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_git_hub, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        val viewPagerAdapter = GitHubViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val tabNames = listOf("Profile", "Repository")
            tab.text = tabNames[position]
        }.attach()

    }



}