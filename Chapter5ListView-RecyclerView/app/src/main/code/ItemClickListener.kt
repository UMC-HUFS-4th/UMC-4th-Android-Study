package com.example.lifecycleprac

interface ItemClickListener {
    fun onClickItemDelete(position: Int)

    fun onClickItemEdit(text: String, position: Int)
}