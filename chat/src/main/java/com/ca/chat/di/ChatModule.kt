package com.ca.chat.di

import com.ca.chat.data.repository.ChatRepositoryImpl
import com.ca.chat.domain.repository.ChatRepository
import com.ca.chat.domain.usecase.GetMessagesUseCase
import com.ca.chat.presentation.ChatViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chatModule = module {
    viewModel { ChatViewModelImpl(get()) }
    single<ChatRepository> { ChatRepositoryImpl() }
    factory { GetMessagesUseCase(get()) }
}