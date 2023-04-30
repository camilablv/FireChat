package com.ca.auth.presentation.signin

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.StateFlow

interface SignInViewModel {
    val uiState: StateFlow<SignInViewState>
    val login: MutableState<String>
    val password: MutableState<String>
    suspend fun signIn(login: String, password: String)
}