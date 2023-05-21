package umc.standard.week5


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dev.recyclerview.databinding.ActivityMemoBinding

class MemoActivity() : AppCompatActivity(){
    private lateinit var viewBinding: ActivityMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        var memo_text = viewBinding.etMemoWrite.text
        viewBinding.btMemoSave.setOnClickListener{

            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("memo text","${memo_text}")
            startActivity(intent)
        }

    }
}