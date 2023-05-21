package umc.standard.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding
    var dataList = ArrayList<Memo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        dataList.apply {
            add(Memo("기본데이터입니다"))
            add(Memo("기본데이터입니다2"))
        }

        val extra = intent.extras
        val data = extra?.get("memo text")
        if(data != null){

        }

        val memoAdapter = MemoAdapter(dataList)
        viewBinding.rvMemo.adapter = memoAdapter
        viewBinding.rvMemo.layoutManager = LinearLayoutManager(this)
        viewBinding.btMemoAdd.setOnClickListener{
            val intent = Intent(this,MemoActivity::class.java)
            startActivity(intent)
        }

        setContentView(viewBinding.root)

    }
}