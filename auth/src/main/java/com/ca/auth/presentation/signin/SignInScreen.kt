package com.ca.auth.presentation.signin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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

@Composable
fun SignInScreen() {

    val scope = rememberCoroutineScope()
    val login = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    Scaffold(
        containerColor = Theme.colors.background
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
                value = login,
                modifier = Modifier
                    .constrainAs(loginTextField) {
                        top.linkTo(signInHeadline.bottom, 36.dp)
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.fillToConstraints
                    }
                ,
                label = "Login",
                errorMessage = null,
                keyboardType = KeyboardType.Text,
                visualTransformation = VisualTransformation.None
            )

            PrimaryTextField(
                value = password,
                modifier = Modifier
                    .constrainAs(passwordTextField) {
                        top.linkTo(loginTextField.bottom, 16.dp)
                        start.linkTo(parent.start, 24.dp)
                        end.linkTo(parent.end, 24.dp)
                        width = Dimension.fillToConstraints
                    }
                    ,
                label = "Password",
                errorMessage = null,
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
                
            }
        }
    }
}

@Composable
@Preview
private fun SignInScreenPreview() {
    ChatTheme {
        SignInScreen()
    }
}