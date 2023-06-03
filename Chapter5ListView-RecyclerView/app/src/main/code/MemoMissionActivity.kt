package com.example.lifecycleprac

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lifecycleprac.adapter.MemoAdapter
import com.example.lifecycleprac.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.properties.Delegates


class MemoMissionActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomSheetView: View
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var bottomSheetBehavior:  BottomSheetBehavior<FrameLayout>
    private lateinit var adapter: MemoAdapter
    private var requestPosition = -1
    private var isRequestFix = false
    private val dataList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet, null)
        bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetBehavior = bottomSheetDialog.behavior

        adapter = MemoAdapter(dataList, this)
        binding.rvMemoContainer.adapter = adapter

        bottomSheetView.findViewById<Button>(R.id.btn_done).setOnClickListener {
            val input: String = bottomSheetView.findViewById<EditText>(R.id.etv_memo_input).text.toString()
            Log.d("작성한 메모 ", input)

            if(isRequestFix == true) {
                handleItemRewrite(input, requestPosition)
                isRequestFix = false
            } else {
                addItem(input)
            }
            bottomSheetDialog.dismiss()
        }


        binding.fabAddMemo.setOnClickListener{
            val editText = bottomSheetView.findViewById<EditText>(R.id.etv_memo_input)
            editText.setText("")
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.fabLayoutChanger.setOnClickListener {
            binding.rvMemoContainer.layoutManager = GridLayoutManager(this, 3)
        }

    }

    private fun addItem(text: String) {
        dataList.add(text)
        adapter.notifyItemInserted(dataList.size - 1)
    }

    private fun handleItemRewrite(text: String, position: Int) {
        if(position != -1) {
            dataList[position] = text
            adapter.notifyItemChanged(position)
        }
    }

    override fun onClickItemDelete(position: Int) {
        dataList.removeAt(position)
        adapter.notifyDataSetChanged()
    }

    override fun onClickItemEdit(text: String, position: Int) {
        isRequestFix = true
        requestPosition = position

        val editText = bottomSheetView.findViewById<EditText>(R.id.etv_memo_input)
        editText.setText(text)

        bottomSheetDialog.show()
    }
}