package com.ca.auth.di

import com.ca.auth.data.repository.SignInRepositoryImpl
import com.ca.auth.domain.repository.SignInRepository
import com.ca.auth.domain.usecase.SignInUseCase
import com.ca.auth.presentation.signin.SignInViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { SignInViewModelImpl(get()) }
    single<SignInRepository> { SignInRepositoryImpl() }
    factory { SignInUseCase(get()) }
}