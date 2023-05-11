package com.ca.core.presentation.components.textfields

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun FilledButton(
    text: String,
    modifier: Modifier,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Theme.colors.primary,
            disabledContainerColor = Theme.colors.background
        ),
        shape = Theme.shapes.button,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            disabledElevation = 0.dp,
            pressedElevation = 1.dp
        )
    ) {
        Text(text = text)
    }
}

@Composable
@Preview
private fun FilledButtonPreview() {
    ChatTheme {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            FilledButton(
                text = "Text",
                modifier = Modifier
                    .width(150.dp),
                enabled = true
            ) {}
        }

    }
}