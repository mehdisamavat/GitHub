package com.example.github.ui.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.github.ui.fragment.profile.ProfileFragment
import com.example.github.ui.fragment.repository.RepositoryFragment

class GitHubViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileFragment.newInstance()
            else -> RepositoryFragment.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}