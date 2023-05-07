package com.example.travelfeeldog.presentation.mypage

import android.os.Bundle
import android.view.View
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentMyPageBinding
import com.example.travelfeeldog.presentation.common.BaseFragment
import com.example.travelfeeldog.presentation.common.NavigationUtil.navigate
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        val mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        binding.clReviewArea.setOnClickListener{
            navigate(R.id.action_nav_my_page_to_myReviewFragment)
        }

        binding.btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            mGoogleSignInClient.signOut().addOnCompleteListener(requireActivity()) { signOut ->
                if(signOut.isSuccessful) {
                    navigate(R.id.action_nav_my_page_to_signInActivity)
                }
            }
        }
    }
}