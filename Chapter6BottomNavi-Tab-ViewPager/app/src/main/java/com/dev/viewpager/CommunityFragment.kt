package com.dev.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.viewpager.databinding.FragmentCameraBinding
import com.dev.viewpager.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {

    private lateinit var viewBindng : FragmentCommunityBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindng = FragmentCommunityBinding.inflate(layoutInflater)
        return viewBindng.root
    }
}