package com.dev.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.viewpager.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private var myAdapter : ViewPager2Adapter? = null
    private var _binding : FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = ViewPager2Adapter(this@SearchFragment)
        binding.vpSearch.adapter = myAdapter

        binding.indicatorSearch.setViewPager(binding.vpSearch)


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }

    companion object {

        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}