package com.dev.recyclerview

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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



        //버튼 클릭하면 메모 추가 화면으로 가기
        //넘겨받은 데이터를 인스턴스화 해서 mdata에 넣기
        clickNewBtn()

        binding.btnNew.setOnClickListener {
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            getResultText.launch(intent)
        }
        
        initUserRecyclerView()

// 시도 1) 아예 onClickListener사 작동하지 않음.
//
//        adapter.setItemClickListener(object: RecyclerViewAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                // 클릭 시 이벤트 작성
//                Log.d(TAG, "listener 작동함")
//                mData.removeAt(position)
//                adapter.notifyDataSetChanged()
//            }
//        })
    }

    override fun onRestart() {
        super.onRestart()
        initUserRecyclerView()
    }

    //어댑터 연결
    fun initUserRecyclerView(){
        //어댑터 객체 만들기
        adapter = RecyclerViewAdapter()
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