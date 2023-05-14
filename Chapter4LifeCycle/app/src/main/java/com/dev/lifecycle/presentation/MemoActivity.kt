package com.dev.lifecycle.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.lifecycle.base.BaseActivity
import com.dev.lifecycle.databinding.ActivityMemoBinding

class MemoActivity : BaseActivity<ActivityMemoBinding>({ActivityMemoBinding.inflate(it)}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}