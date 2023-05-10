package com.ca.chat.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ca.core.presentation.theme.ChatTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatScreen(
    viewModel: ChatViewModelImpl = koinViewModel()
) {


}

@Composable
@Preview
private fun ChatScreenPreview() {

    ChatTheme {
        ChatScreen()
    }
}