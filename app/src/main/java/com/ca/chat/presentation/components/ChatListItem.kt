package com.ca.chat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.chat.domain.model.ChatListItem
import com.ca.core.presentation.components.Avatar
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun ChatListItem(
    item: ChatListItem
) {
    Surface(
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Avatar(
                modifier = Modifier
                    .size(70.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.nickname,
                        style = Theme.typography.bodyLarge
                    )
                    Text(
                        text = item.lastMessageTimestamp
                    )
                }

                Text(
                    text = item.lastMessage
                )

            }
        }
    }
}

@Composable
@Preview
private fun ChatListItemPreview() {
    ChatTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            ChatListItem(
                avatarUrl = "",
                nickname = "Dima",
                lastMessage = "Last message bla bla...",
                lastMessageTimestamp = "13:16"
            )
        }
    }
}