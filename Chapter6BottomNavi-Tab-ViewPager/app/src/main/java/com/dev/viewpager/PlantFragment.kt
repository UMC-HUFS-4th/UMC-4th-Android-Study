package com.dev.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.viewpager.databinding.FragmentPlantBinding

class PlantFragment : Fragment() {

    private lateinit var viewBindng: FragmentPlantBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBindng = FragmentPlantBinding.inflate(layoutInflater)
        return viewBindng.root
    }
}