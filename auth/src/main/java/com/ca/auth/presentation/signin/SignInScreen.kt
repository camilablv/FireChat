package com.ca.auth.presentation.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ca.core.presentation.components.textfields.FilledButton
import com.ca.core.presentation.components.textfields.PrimaryTextField
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SignInScreen(
    viewModel: SignInViewModelImpl = koinViewModel(),
    navigateTo: () -> Unit
) {

    val scope = rememberCoroutineScope()
    val viewState by viewModel.viewState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    if (viewState.signInSuccessful) navigateTo()

    Scaffold(
        containerColor = Theme.colors.background,
        snackbarHost = { SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .padding(bottom = 70.dp)
        ) }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
        ) {
            val (signInHeadline, loginTextField, passwordTextField, signInButton) = createRefs()


            Text(
                text = "Sign In",
                modifier = Modifier
                    .constrainAs(signInHeadline) {
                        top.linkTo(parent.top, 100.dp)
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.fillToConstraints
                    }
                ,
                style = Theme.typography.headerMiddle,
                color = Theme.colors.onBackground
            )

            PrimaryTextField(
                value = viewModel.login,
                modifier = Modifier
                    .constrainAs(loginTextField) {
                        top.linkTo(signInHeadline.bottom, 36.dp)
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.fillToConstraints
                    }
                ,
                label = "Login",
                errorMessage = viewState.loginError,
                keyboardType = KeyboardType.Text,
                visualTransformation = VisualTransformation.None
            )

            PrimaryTextField(
                value = viewModel.password,
                modifier = Modifier
                    .constrainAs(passwordTextField) {
                        top.linkTo(loginTextField.bottom, 16.dp)
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.fillToConstraints
                    }
                    ,
                label = "Password",
                errorMessage = viewState.passwordError,
                keyboardType = KeyboardType.Text,
                visualTransformation = PasswordVisualTransformation()
            )

            FilledButton(
                text = "Sign In",
                modifier = Modifier
                    .constrainAs(signInButton) {
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.fillToConstraints
                        bottom.linkTo(parent.bottom, 24.dp)
                    },
                enabled = true
            ) {
                scope.launch {
                    viewModel.signIn(viewModel.login.value, viewModel.password.value)
                    navigateTo.invoke() //todo remove it
                }
            }
        }

        if (viewState.authError != null) {
            scope.launch { snackbarHostState.showSnackbar(viewState.authError!!) }
        }
    }
}

@Composable
@Preview
private fun SignInScreenPreview() {
    ChatTheme {
        SignInScreen() {

        }
    }
}