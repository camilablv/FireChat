package com.ca.chat.di

import com.ca.chat.presentation.ChatViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chatModule = module {
    viewModel { ChatViewModelImpl() }
}