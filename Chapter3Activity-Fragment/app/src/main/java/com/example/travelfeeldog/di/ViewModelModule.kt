package com.example.travelfeeldog.di

import com.example.travelfeeldog.util.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { TestViewModel(get()) }
}