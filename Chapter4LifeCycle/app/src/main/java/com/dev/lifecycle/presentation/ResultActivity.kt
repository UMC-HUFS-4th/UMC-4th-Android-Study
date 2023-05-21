package com.dev.lifecycle.presentation

import android.os.Bundle
import android.util.Log
import com.dev.lifecycle.base.BaseActivity
import com.dev.lifecycle.databinding.ActivityMemoBinding
import com.dev.lifecycle.databinding.ActivityResultBinding

class ResultActivity:BaseActivity<ActivityResultBinding>({ ActivityResultBinding.inflate(it)}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        var tmpString = ""
        if(bundle!=null){
            tmpString = bundle.getString("text","have no text")
            Log.d("Result", tmpString)
            binding.tvResultText.text = tmpString
        }
    }

}