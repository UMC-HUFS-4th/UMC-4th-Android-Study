package com.example.travelfeeldog.data.model.test

import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("body")
    val body: Int,
    @SerializedName("header")
    val header: Header
)

data class Header(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)