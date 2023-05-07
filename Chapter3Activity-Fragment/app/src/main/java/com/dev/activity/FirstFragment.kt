package com.dev.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.dev.activity.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
private lateinit var viewBinidng : FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinidng = FragmentFirstBinding.inflate(layoutInflater)
        viewBinidng.btFirstFragment.setOnClickListener{
            val result = viewBinidng.etFirstFragment.text.toString()
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
        return viewBinidng.root

    }
}