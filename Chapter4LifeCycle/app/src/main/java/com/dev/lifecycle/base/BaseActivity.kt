package com.dev.lifecycle.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
val TAG = "LifeCycle"
abstract class BaseActivity<VB: ViewBinding>(val bindingFactory: (LayoutInflater) ->VB):AppCompatActivity() {
    private var _binding: VB? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"onRestart")
    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy")
    }


}