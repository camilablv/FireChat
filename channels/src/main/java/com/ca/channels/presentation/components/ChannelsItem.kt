package com.ca.channels.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.channels.domain.model.Channel
import com.ca.core.presentation.components.Avatar
import com.ca.core.presentation.components.NewMessagesCount
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun ChannelsItem(
    channel: Channel,
    onClick: () -> Unit
) {
    Surface(
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(4.dp)
                .clickable { onClick() },
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Avatar(
                modifier = Modifier
                    .size(70.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 4.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = channel.nickname,
                        style = Theme.typography.bodyLarge
                    )
                    Text(
                        text = channel.lastMessageTimestamp
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = channel.lastMessage
                    )
                    NewMessagesCount(
                        channel.unreadMessagesCount
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun ChannelsItemPreview() {

    val channel = Channel(
        avatarUrl = "",
        nickname = "Dima",
        lastMessage = "Last message...",
        lastMessageTimestamp = "13:16",
        unreadMessagesCount = 3
    )
    
    ChatTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            ChannelsItem(channel = channel) {}
        }
    }
}