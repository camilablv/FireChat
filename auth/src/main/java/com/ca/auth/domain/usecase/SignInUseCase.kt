package com.ca.auth.domain.usecase

import com.ca.auth.domain.repository.SignInRepository

class SignInUseCase(private val repository: SignInRepository) {

    suspend fun signIn(login: String, password: String) {
        repository.signIn(login, password)
    }
}