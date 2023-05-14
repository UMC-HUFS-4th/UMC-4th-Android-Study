package com.dev.lifecycle.presentation

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.dev.lifecycle.base.BaseActivity
import com.dev.lifecycle.base.TAG
import com.dev.lifecycle.databinding.ActivityMemoBinding

class MemoActivity : BaseActivity<ActivityMemoBinding>({ActivityMemoBinding.inflate(it)}) {
    var editText:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btMemoNext.setOnClickListener{

        }
    }
    override fun onResume() {
        super.onResume()
        binding.etMemeoText.setText(editText)
    }

    override fun onPause() {
        super.onPause()
        editText = binding.etMemeoText.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("작성한 내용이 임시저장되었습니다.")
            .setMessage("계속 작성하시겠습니까?")
            .setPositiveButton("예", object: DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    Log.d(TAG, "Continue")
                }
            })
            .setNegativeButton("아니오", object: DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    Log.d(TAG, "negative")
                    editText = ""
                }
            })
            .create()
            .show()
    }

}