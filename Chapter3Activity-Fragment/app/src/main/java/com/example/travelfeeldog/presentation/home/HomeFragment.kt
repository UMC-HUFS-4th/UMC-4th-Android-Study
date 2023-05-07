package com.example.travelfeeldog.presentation.home

import android.media.metrics.Event
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentHomeBinding
import com.example.travelfeeldog.presentation.common.BaseFragment
import com.example.travelfeeldog.presentation.common.NavigationUtil.navigate
import com.example.travelfeeldog.presentation.home.adapter.EventBannerAdapter
import com.example.travelfeeldog.presentation.home.item.EventBanner

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO(고정된 정보 - 나중에 고정된 정보끼리 데이터 셋 만들 것)
        val eventBannerInfo = mutableListOf<EventBanner>().apply {
            add(
                EventBanner(
                    R.drawable.bg_gradient_red_pinkpurple,
                    R.drawable.img_3d_package,
                    R.string.first_sub_title,
                    R.string.first_main_title
                )
            )
            add(
                EventBanner(
                    R.drawable.bg_gradient_blue_purple,
                    R.drawable.ic_3d_discount,
                    R.string.second_sub_title,
                    R.string.second_main_title
                )
            )
        }

        setHomeEventBanner(eventBannerInfo, 2)
    }

    private fun mainViewChangeEvent(maxEvent: Int) {
        binding.vpAdBoard.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.vAdIndicator.text = "${position + 1} / ${maxEvent}"
            }
        })
    }

    private fun setHomeEventBanner(itemList: MutableList<EventBanner>, maxEvent: Int) {
        binding.vpAdBoard.apply {
            binding.vAdIndicator.text = "1 / ${itemList.size}"
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 1
            adapter = EventBannerAdapter(requireActivity(), itemList)
        }
        mainViewChangeEvent(maxEvent)
    }
}