package com.example.travelfeeldog.presentation.location

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentLocationDetailBinding
import com.example.travelfeeldog.presentation.common.BaseFragment
import com.example.travelfeeldog.presentation.common.NavigationUtil.navigate

class LocationDetailFragment : BaseFragment<FragmentLocationDetailBinding>(R.layout.fragment_location_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clLikeStaticsArea.setOnClickListener {
            navigate(R.id.action_locationDetailFragment_to_positiveEvaluationFragment)
        }

        binding.clBadStaticsArea.setOnClickListener {
            navigate(R.id.action_locationDetailFragment_to_negativeEvaluationFragment)
        }

        binding.btnRequestReview.setOnClickListener {
            navigate(R.id.action_locationDetailFragment_to_placeReviewFragment)
        }

        binding.tvMoveReviewPage.setOnClickListener {
            navigate(R.id.action_locationDetailFragment_to_reviewFragment)
        }
    }

}