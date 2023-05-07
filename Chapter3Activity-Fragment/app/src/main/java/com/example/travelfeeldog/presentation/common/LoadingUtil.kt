package com.example.travelfeeldog.presentation.common

import android.view.View
import com.airbnb.lottie.LottieAnimationView

object LoadingUtil {

    fun playAnimation(loadingView: LottieAnimationView) {
        loadingView.visibility = View.VISIBLE
        loadingView.playAnimation()
    }

    fun cancelAnimation(loadingView: LottieAnimationView) {
        loadingView.cancelAnimation()
        loadingView.visibility = View.INVISIBLE
    }
}