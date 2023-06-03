package com.dev.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(f : Fragment) : FragmentStateAdapter(f) {
    private val PAGENUMBER = 3

    override fun getItemCount(): Int {
        return PAGENUMBER
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ImageFragment.newInstance(R.drawable.dobby1)
            1 -> ImageFragment.newInstance(R.drawable.dobby3)
            2 -> ImageFragment.newInstance(R.drawable.dobby2)
            else -> ImageFragment.newInstance(R.drawable.dobby1)
        }
    }

}