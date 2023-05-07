package com.example.travelfeeldog.presentation.signin

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.example.travelfeeldog.BuildConfig
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.FragmentSignInBinding
import com.example.travelfeeldog.presentation.common.BaseFragment
import com.example.travelfeeldog.presentation.common.LoadingUtil
import com.example.travelfeeldog.presentation.common.NavigationUtil.navigate
import com.example.travelfeeldog.util.TestViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : BaseFragment<FragmentSignInBinding>(R.layout.fragment_sign_in) {

    private val viewModel: TestViewModel by viewModel()
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        val googleLogInRequest =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    val googleIdToken: String? = getGoogleAccount(task).idToken
                    try {
                        lifecycleScope.launch {
                            signInWithFireBase(googleIdToken)
                        }
                        LoadingUtil.playAnimation(binding.lavLoading)
                    } catch (e: ApiException) {
                        Log.d("googleLogIn:failure", e.toString())
                    }
                }
            }

        binding.btnSignIn.setOnClickListener {
            googleLogInRequest.launch(googleSignInClient.signInIntent)
        }
    }

    private fun getGoogleAccount(completedTask: Task<GoogleSignInAccount>): GoogleSignInAccount {
        return completedTask.getResult(ApiException::class.java)
    }

    private suspend fun signInWithFireBase(googleIdToken: String?) = withContext(Dispatchers.IO) {
        auth.signInWithCredential(GoogleAuthProvider.getCredential(googleIdToken, null))
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    LoadingUtil.cancelAnimation(binding.lavLoading)
                    Log.d("signInWithCredential:success", auth.uid.toString())
                    navigate(R.id.action_signInFragment_to_mainActivity)
                } else {
                    Log.d(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }
}