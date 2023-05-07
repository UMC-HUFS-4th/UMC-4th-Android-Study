package com.example.travelfeeldog.presentation.review

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.PopupMenu
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentReviewBinding
import com.example.travelfeeldog.presentation.common.BaseFragment

class ReviewFragment : BaseFragment<FragmentReviewBinding>(R.layout.fragment_review), PopupMenu.OnMenuItemClickListener {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReviewSearchOption.setOnClickListener {
            showPopup(it)
        }
    }

    private fun showPopup(v: View) {
        val popup = PopupMenu(requireActivity(), v, Gravity.END)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_review_search, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.option_date-> {
                Log.d("clickMenu", "date")
                true
            }
            R.id.option_like -> {
                Log.d("clickMenu", "like")
                true
            }
            R.id.option_normal -> {
                Log.d("clickMenu", "normal")
                true
            }
            R.id.option_dislike -> {
                Log.d("clickMenu", "dislike")
                true
            }
            else -> false
        }
    }

}