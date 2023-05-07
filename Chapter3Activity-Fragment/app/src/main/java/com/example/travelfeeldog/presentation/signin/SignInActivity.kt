package com.example.travelfeeldog.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.travelfeeldog.R
import com.example.travelfeeldog.databinding.ActivitySignInBinding
import com.example.travelfeeldog.presentation.MainActivity
import com.example.travelfeeldog.presentation.common.BaseActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in){

    override fun onStart() {
        super.onStart()
        val currentUser = Firebase.auth.currentUser
        if(currentUser != null) {
            Log.d("already exist!", currentUser.toString())
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}