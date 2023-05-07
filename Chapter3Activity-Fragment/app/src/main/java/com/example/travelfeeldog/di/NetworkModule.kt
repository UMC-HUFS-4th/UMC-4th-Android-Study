package com.example.travelfeeldog.di

import com.example.travelfeeldog.data.network.NetworkInterceptor
import com.example.travelfeeldog.data.network.api.TestApi
import com.example.travelfeeldog.util.Constants.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addNetworkInterceptor(NetworkInterceptor())
            .addInterceptor(Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().build()
                )
            })
            .build()
    }

    single<Retrofit> {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .client(get())
                .baseUrl(BASE_URL)
                .build()
    }

    single<TestApi> {
        get<Retrofit>().create(TestApi::class.java)
    }
}