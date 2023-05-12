package com.ca.chat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.chat.domain.model.Message
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

enum class MessagePosition {
    START,
    END
}

@Composable
fun ChatItem(
    message: Message,
    modifier: Modifier,
    position: MessagePosition
) {
    val alignment = if (position == MessagePosition.START) Alignment.Start else Alignment.End

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = alignment
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Theme.colors.secondary
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Text(
                text = message.body,
                style = Theme.typography.bodyLarge,
                modifier = Modifier
                    .padding(8.dp)
                    .widthIn(min = 50.dp, 250.dp)
            )
        }

        Text(
            text = message.createdAt,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
        )
    }
}

@Composable
@Preview
private fun ChatItemPreview() {
    val message = Message(
        id = "",
        body = "Any message",
        userId = "",
        createdAt = "16:45",
        viewedBy = emptyList()
    )
    ChatTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
        ) {
            ChatItem(
                message = message,
                modifier = Modifier,
                position = MessagePosition.END
            )
        }
    }
}