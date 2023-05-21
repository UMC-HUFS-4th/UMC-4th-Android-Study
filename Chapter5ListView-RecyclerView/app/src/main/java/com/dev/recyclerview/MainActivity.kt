package com.dev.recyclerview

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.recyclerview.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    //미리 뷰바인딩 객체와 어댑터 객체 선언
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    //데이터 넣을 리스트 선언
    private var mData = mutableListOf<MemoData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view binding 처리
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUserRecyclerView()
        clickNewBtn()

        binding.btnNew.setOnClickListener {
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            getResultText.launch(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        adapter.notifyDataSetChanged()
//        initUserRecyclerView()
    }

    //어댑터 연결
    fun initUserRecyclerView(){
        //어댑터 객체 만들기
        adapter = RecyclerViewAdapter(object : RecyclerViewAdapter.OnMemoClickListener {
            override fun onMemoClick(position: Int) {
                //intent전달하기
                val iIntent = Intent(this@MainActivity, SubActivity::class.java)
                iIntent.putExtra("content", mData[position].memo.toString())
                getResultText.launch(iIntent)
                Log.d(TAG, "${position}번 아이템 클릭")
            }
        })
        //데이터 넣기
        adapter.datalist = mData
        //리사이클러뷰에 어댑터 연결
        binding.rvMain.adapter = adapter
        //레이아웃매니저 연결
        binding.rvMain.layoutManager=LinearLayoutManager(this@MainActivity)
    }

    private fun clickNewBtn(){
        with(binding){
            getResultText = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result.resultCode == RESULT_OK) {
                    val mString = result.data?.getStringExtra("back_message")
                    //현재시간 가져오기
                    Log.d(TAG, "서브에서 받기 : " + mString )
                    val date = LocalDate.now().toString()
                    addData(mString, date)
                }
            }
        }
    }

    private fun addData(memo : String?, date : String){
        //새로운 데이터를 넣어서 add처리
        mData.add(MemoData(memo, date))
    }

}