package com.ca.channels.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ca.channels.domain.model.Channel
import com.ca.channels.presentation.components.ChannelsItem
import com.ca.channels.presentation.components.ChannelsTopBar
import com.ca.core.presentation.theme.ChatTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChannelsScreen(
    viewModel: ChannelsViewModelImpl = koinViewModel(),
    navigateToChannel: () -> Unit
) {

    val chats = List(20) {
        Channel("", "Dima", "Last message...", "12:08", 3)
    }

    Scaffold(
        topBar = { ChannelsTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            items(chats.size) {
                ChannelsItem(channel = chats[it]) {
                    navigateToChannel()
                }
            }
        }
    }
}

@Composable
@Preview
private fun ChatListScreenPreview() {
    ChatTheme {
        ChannelsScreen(
            navigateToChannel = {}
        )
    }
}