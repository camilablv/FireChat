package com.ca.chat.presentation.chatlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ca.chat.domain.model.ChatListItem
import com.ca.chat.presentation.components.ChatListItem
import com.ca.chat.presentation.components.HomeTopBar
import com.ca.core.presentation.theme.ChatTheme

@Composable
fun ChatListScreen() {

    val chats = List(20) {
        ChatListItem("", "Dima", "message", "12:08")
    }

    Scaffold(
        topBar = { HomeTopBar() }
    ) {
        LazyColumn {
            items(chats.size) {
                ChatListItem(item = chats[it])
            }
        }
    }
}

@Composable
@Preview
private fun ChatListScreenPreview() {
    ChatTheme {
        ChatListScreen()
    }
}