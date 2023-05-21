package com.example.lifecycleprac.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycleprac.R

class MyAdapter(private val dataList: List<String>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val stateList: MutableList<Boolean> = MutableList(dataList.size) {false}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_switch, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.switchButton.text = position.toString()
        holder.switchButton.isChecked = stateList[position]
        holder.handleSwitchClicked(position)
    }

    override fun getItemCount(): Int = dataList.size

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val switchButton = view.findViewById<SwitchCompat>(R.id.sv_switch)
        fun handleSwitchClicked(position: Int) {
            switchButton.setOnClickListener {
                stateList[position] = switchButton.isChecked
                Log.d("click event", switchButton.isChecked .toString())
            }
        }

    }
}