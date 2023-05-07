package com.example.travelfeeldog.presentation.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentSignUpBinding
import com.example.travelfeeldog.presentation.common.BaseFragment
import com.example.travelfeeldog.presentation.common.NavigationUtil.navigate

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSingUpDone.setOnClickListener {
            navigate(R.id.action_signUpFragment_to_mainActivity)
            requireActivity().finish()
        }
    }
}