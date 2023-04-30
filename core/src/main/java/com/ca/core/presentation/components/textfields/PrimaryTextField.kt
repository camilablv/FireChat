package com.ca.core.presentation.components.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun PrimaryTextField(
    value: MutableState<String>,
    modifier: Modifier,
    label: String = "",
    errorMessage: String? = null,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation
) {
    var isError by remember(errorMessage) { mutableStateOf(errorMessage != null) }

    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value.value,
            onValueChange = {
                isError = false
                value.value = it
            },
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(60.dp)
                .semantics { contentDescription = "email_input_field" },
            textStyle = Theme.typography.bodyLarge,
            label = { Text(text = label) },
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Theme.colors.surface,
                unfocusedContainerColor = Theme.colors.surface,
                errorLabelColor = Theme.colors.error,
                cursorColor = Theme.colors.onBackground,
                focusedTextColor = Theme.colors.onBackground,
                errorContainerColor = Theme.colors.surface,
                unfocusedLabelColor = Theme.colors.onSurface,
                focusedLabelColor = Theme.colors.onSurface
            ),
            isError = isError,
            singleLine = true,
            shape = Theme.shapes.textField,
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Error, "error_icon", tint = Theme.colors.error)
            },
        )

        Text(
            text = if (isError) errorMessage!! else "",
            color = Theme.colors.error,
            style = Theme.typography.bodyLarge,
            modifier = Modifier
        )
    }
}

@Composable
@Preview
private fun PrimaryTextFieldPreview() {
    val value = remember {
        mutableStateOf("")
    }

    ChatTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
        )
        PrimaryTextField(
            value = value,
            modifier = Modifier
                .padding(36.dp),
            keyboardType = KeyboardType.Email,
            visualTransformation = VisualTransformation.None,
            label = "Login",
            errorMessage = null
        )
    }
}