package umc.standard.week5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev.recyclerview.databinding.ListviewItemBinding

//interface OnItemClickListener{
//    void onEditClick(View v, int position);
//    void onDeleteClick(View v, int position);
//}
class MemoAdapter(private val dataList : ArrayList<Memo>):RecyclerView.Adapter<MemoAdapter.DataViewHolder>() {

    //ViewHolder 객체
    inner class DataViewHolder(private val viewBinding: ListviewItemBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data : Memo){
            viewBinding.tvMemoText.text = data.text
        }
    }
    //ViewHolder 만들어질때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ListviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(viewBinding)
    }
    //ViewHolder가 실제로 데이터를 표시해야할때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
    //표현할 Item의 총 갯수
    override fun getItemCount(): Int = dataList.size
    override fun getItemViewType(position: Int): Int {
        return position
    }
}