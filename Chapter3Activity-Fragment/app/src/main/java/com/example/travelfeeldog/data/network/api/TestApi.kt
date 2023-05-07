package com.example.travelfeeldog.data.network.api

import com.example.travelfeeldog.data.model.test.TestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TestApi {

    @GET("v1/test/{testnumber}")
    suspend fun testConnectServer(
        @Path("testnumber") testNumber: Int
    ) : Call<TestResponse>

}