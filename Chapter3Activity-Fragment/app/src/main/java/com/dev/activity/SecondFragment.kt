package com.dev.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.activity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var viewBinidng : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinidng = FragmentSecondBinding.inflate(layoutInflater)
        return viewBinidng.root
    }
}
