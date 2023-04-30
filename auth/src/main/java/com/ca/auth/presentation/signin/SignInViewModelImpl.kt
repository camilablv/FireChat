package com.ca.auth.presentation.signin

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ca.auth.domain.usecase.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInViewModelImpl(useCase: SignInUseCase) : ViewModel(), SignInViewModel {

    private val _viewState: MutableStateFlow<SignInViewState> = MutableStateFlow(SignInViewState())
    override val uiState: StateFlow<SignInViewState>
        get() = _viewState

    override val login: MutableState<String>
        get() = mutableStateOf("")
    override val password: MutableState<String>
        get() = mutableStateOf("")

    override suspend fun signIn(login: String, password: String) {
        TODO("Not yet implemented")
    }
}