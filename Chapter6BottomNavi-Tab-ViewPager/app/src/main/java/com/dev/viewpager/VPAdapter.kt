package com.dev.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: HomeFragment): FragmentStateAdapter(fragmentActivity) {
    // 페이지 갯수 설정
    override fun getItemCount() = 3

    // 불러올 Fragment 정의
    override fun createFragment(position: Int): Fragment{
        return when (position){
            0 -> CircleFragment()
            1 -> PlantFragment()
            2 -> CommunityFragment()
            else -> CommunityFragment()
        }

    }
}
