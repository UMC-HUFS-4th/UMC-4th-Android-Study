package com.example.travelfeeldog.util

import android.app.Application
import com.example.travelfeeldog.di.networkModule
import com.example.travelfeeldog.di.viewModelModule
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule, viewModelModule)
        }

        FirebaseApp.initializeApp(this);
    }


}