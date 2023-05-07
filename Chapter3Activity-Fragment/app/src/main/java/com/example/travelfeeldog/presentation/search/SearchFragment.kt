package com.example.travelfeeldog.presentation.search

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.PopupMenu
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentSearchBinding
import com.example.travelfeeldog.presentation.common.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search), PopupMenu.OnMenuItemClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOptionLocation.setOnClickListener {
            showPopup(it, R.menu.menu_search_option_location)
        }

        binding.btnOptionCategory.setOnClickListener {
            showPopup(it, R.menu.menu_search_option_category)
        }

        //TODO(카테고리 별 키워드 메뉴 제작해서 코드 작성하기)
//        binding.btnOptionKeyword.setOnClickListener {
//            showPopup(it, 0)
//        }
    }

    private fun showPopup(v: View, menuRes: Int) {
        val popup = PopupMenu(requireActivity(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(menuRes, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            // option - location
            R.id.location_seoul -> {
                Log.d("clickMenu", "seoul")
                true
            }
            R.id.location_jeju -> {
                Log.d("clickMenu", "jeju")
                true
            }
            R.id.location_gangwon -> {
                Log.d("clickMenu", "gangWon")
                true
            }
            R.id.option_dislike -> {
                Log.d("clickMenu", item.toString())
                true
            }

            // option - category
            R.id.category_lodging -> {
                Log.d("clickMenu", item.toString())
                true
            }
            R.id.category_walking -> {
                Log.d("clickMenu", item.toString())
                true
            }
            R.id.category_cafe_food -> {
                Log.d("clickMenu", item.toString())
                true
            }

            else -> false
        }
    }
}