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
import com.ca.core.presentation.components.Avatar
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun ChatListItem(

) {
    Surface(
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Avatar()
            Column(

            ) {
                Text(
                    text = "Dima",
                    style = Theme.typography.bodyLarge
                )
                Text(
                    text = "Message"
                )
                Text(
                    text = "13:30"
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
                .fillMaxWidth()
                .height(200.dp)
                .background(Theme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            ChatListItem()
        }
    }
}