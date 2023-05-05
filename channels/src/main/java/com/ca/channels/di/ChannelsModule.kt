package com.ca.channels.di

import com.ca.channels.data.repository.ChannelsRepositoryImpl
import com.ca.channels.domain.repository.ChannelsRepository
import com.ca.channels.domain.usecase.GetChannelsUseCase
import com.ca.channels.presentation.ChannelsViewModel
import com.ca.channels.presentation.ChannelsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val channelsModule = module {
    viewModel { ChannelsViewModelImpl(get()) }
    single<ChannelsRepository> { ChannelsRepositoryImpl() }
    factory { GetChannelsUseCase(get()) }

}