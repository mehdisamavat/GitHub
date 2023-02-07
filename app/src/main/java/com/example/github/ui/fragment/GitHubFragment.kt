package com.example.github.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.github.R
import com.example.github.databinding.FragmentGitHubBinding
import com.example.github.ui.fragment.adapter.GitHubViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class GitHubFragment : Fragment() {


    private lateinit var binding: FragmentGitHubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ( requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.miBookMark -> {
                        findNavController(this@GitHubFragment).navigate(R.id.bookmarkFragment)
                        true
                    }
                    else -> return false
                }
            }
            override fun onMenuClosed(menu: Menu) {
                super.onMenuClosed(menu)
                menu.clear()
            }
        })
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