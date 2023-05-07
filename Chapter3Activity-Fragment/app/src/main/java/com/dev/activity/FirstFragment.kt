package com.dev.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.activity.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
private lateinit var viewBinidng : FragmentFirstBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinidng = FragmentFirstBinding.inflate(layoutInflater)
        return viewBinidng.root
    }
}