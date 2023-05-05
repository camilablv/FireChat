package com.ca.channels.di

import com.ca.channels.data.repository.ChannelsRepositoryImpl
import com.ca.channels.domain.usecase.GetChannelsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val channelsModule = module {
    viewModel { com.ca.channels.presentation.ChannelsViewModelImpl(get()) }
    factory { GetChannelsUseCase(get()) }
    factory { ChannelsRepositoryImpl() }
}