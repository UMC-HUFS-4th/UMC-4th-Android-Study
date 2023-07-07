package com.dev.viewpager

import ImageAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.dev.viewpager.databinding.FragmentCircleBinding
import me.relex.circleindicator.CircleIndicator3




class CircleFragment : Fragment() {

    private lateinit var viewBindng : FragmentCircleBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3
    private lateinit var viewpagerAdapter: ImageAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindng = FragmentCircleBinding.inflate(layoutInflater)
        return viewBindng.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewpagerAdapter = ImageAdapter(this)
        viewPager = viewBindng.layoutViewpager
        viewPager.adapter = viewpagerAdapter
        indicator = viewBindng.layoutIndicator
        indicator.setViewPager(viewPager);
    }

}