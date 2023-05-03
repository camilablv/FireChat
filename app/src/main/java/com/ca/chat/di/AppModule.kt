package com.ca.chat.di

import com.ca.chat.data.repository.ChatRepositoryImpl
import com.ca.chat.domain.usecase.GetChatListUseCase
import com.ca.chat.presentation.ChatViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ChatViewModelImpl(get()) }
    factory { GetChatListUseCase(get()) }
    factory { ChatRepositoryImpl() }
}