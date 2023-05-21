package com.dyongchan.ch05_switch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.dyongchan.ch05_switch.databinding.ListItemBinding

class CustomAdapter(context:Context,private val businessCardArray:ArrayList<BusinessCard>) : BaseAdapter() {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ListItemBinding

    override fun getCount(): Int {
        return businessCardArray.size
    }

    override fun getItem(position: Int): Any {
        return businessCardArray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = ListItemBinding.inflate(inflater,parent,false)
        binding.tvName.text = businessCardArray[position].name
        binding.tvIntro.text = businessCardArray[position].contents
        binding.mainSwitch.isChecked = businessCardArray[position].isSwitched
        // 코드 이해가 좀 어렵다
        binding.mainSwitch.setOnCheckedChangeListener { buttonView, isChecked -> businessCardArray[position].isSwitched = isChecked}

        return binding.root
    }
}