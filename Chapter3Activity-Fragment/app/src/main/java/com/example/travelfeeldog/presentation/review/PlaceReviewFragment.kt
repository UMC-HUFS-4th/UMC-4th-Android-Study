package com.example.travelfeeldog.presentation.review

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.NumberPicker
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.marginRight
import androidx.core.view.setPadding
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentPlaceReviewBinding
import com.example.travelfeeldog.presentation.common.BaseFragment
import com.google.android.material.chip.Chip


class PlaceReviewFragment :
    BaseFragment<FragmentPlaceReviewBinding>(R.layout.fragment_place_review) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNumberPickerInit(binding.npSmallDog, 0, 50, 0)
        setNumberPickerInit(binding.npNormal, 0, 50, 0)
        setNumberPickerInit(binding.npLarge, 0, 50, 0)

        // Test Code - Dynamic Chip
        val positiveKeywordList = listOf(
            "주변에 산책할 장소가 많아요",
            "방음이 좋아요",
            "벌레로부터 안전해요",
            "냉난방이 잘돼요",
            "시설이 안전해요",
            "시설이 청결해요",
            "냄새 없이 쾌적해요",
            "공간이 충분히 넓어요",
            "추가적인 반려견 용품 제공을 해줘요"
        )

        val negativeKeywordList = listOf(
            "기존 숙소 정보랑 달라요",
            "방음이 좋지 않아요",
            "벌레나 해충이 많아요",
            "냉난방이 잘 안돼요",
            "시설이 안전하지 않아요",
            "청결하지 않아요",
            "냄새가 심해요",
            "공간이 충분히 넓지 않아요",
            "주변에 반려견동물과 함께 다닐 장소가 부족해요"
        )

        for (keyword in positiveKeywordList) {
            val chip = layoutInflater.inflate(
                R.layout.item_custom_chip_positive,
                binding.cgLikeKeywordGroup,
                false
            ) as Chip
            binding.cgLikeKeywordGroup.addView(chip.apply {
                text = keyword
                isCheckedIconVisible = false
            })
        }

        for (keyword in negativeKeywordList) {
            val chip = layoutInflater.inflate(
                R.layout.item_custom_chip_negative,
                binding.cgDislikeKeywordGroup,
                false
            ) as Chip
            binding.cgDislikeKeywordGroup.addView(chip.apply {
                text = keyword
                isCheckedIconVisible = false
            })
        }

        // Photo picker test
        val pickMultipleMedia =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(3)) { uris ->
                if (uris.isNotEmpty()) {
                    Log.d("PhotoPicker", "Number of items selected: ${uris.size}")
                    binding.llPhotoContainer.removeAllViewsInLayout()
                    for (uri in uris) {
                        val iv = layoutInflater.inflate(
                            R.layout.item_photo_viewer,
                            binding.llPhotoContainer,
                            false
                        ) as ImageView
                        binding.llPhotoContainer.addView(iv.apply {
                            setImageURI(uri)
                        })
                    }
                } else {
                    Log.d("PhotoPicker", "No media selected")
                }
            }

        binding.btnAddPhoto.setOnClickListener {
            pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

    }

    private fun setNumberPickerInit(v: NumberPicker, min: Int, max: Int, initValue: Int) {
        v.minValue = min
        v.maxValue = max
        v.value = initValue
    }
}