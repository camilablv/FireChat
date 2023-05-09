package com.ca.auth.data.repository

import com.ca.auth.domain.repository.SignInRepository

class SignInRepositoryImpl : SignInRepository {
    override suspend fun signIn(login: String, password: String) {

    }
}