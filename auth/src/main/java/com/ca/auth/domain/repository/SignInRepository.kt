package com.ca.auth.domain.repository

import arrow.core.Either

interface SignInRepository {
    suspend fun signIn(login: String, password: String)
}