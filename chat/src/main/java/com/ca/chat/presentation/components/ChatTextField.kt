package com.ca.chat.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTextField(
    value: MutableState<String>,
    modifier: Modifier
) {

    Surface(
        modifier = modifier,
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(25.dp)
    ) {
        BasicTextField(
            value = value.value,
            onValueChange = {
                value.value = it
            },
            modifier = Modifier
                .heightIn(42.dp, 86.dp)
                .animateContentSize(),
            maxLines = 6
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value.value,
                placeholder = {
                    Text(
                        text = "Type here...")
                },
                enabled = true,
                innerTextField = innerTextField,
                interactionSource = MutableInteractionSource(),
                singleLine = false,
                visualTransformation = VisualTransformation.None,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                contentPadding = PaddingValues(12.dp)
            )
        }
    }
}

@Composable
@Preview
private fun ChatTextFieldPreview() {
    val text = remember {
        mutableStateOf("")
    }
    ChatTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.primary)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color.White, Theme.colors.primary)
                    )
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            ChatTextField(
                value = text,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}
