package com.ca.auth.presentation.signin

data class SignInViewState(
    var loading: Boolean = false,
    var signInSuccessful: Boolean = false,
    var loginError: String? = null,
    var passwordError: String? = null,
    var authError: String? = null
)