package com.ca.chat.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.chat.R
import com.ca.chat.presentation.components.ChatItem
import com.ca.chat.presentation.components.ChatTextField
import com.ca.chat.presentation.components.ChatTopBar
import com.ca.chat.presentation.components.MessagePosition
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Purple80
import com.ca.core.presentation.theme.Theme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen(
    viewModel: ChatViewModelImpl = koinViewModel(),
    onAvatarClick: () -> Unit,
    onNavigationIconClick: () -> Unit
) {

    val messages by viewModel.messages.collectAsState()
    val lazyListState = rememberLazyListState()

    LaunchedEffect(messages.isEmpty()) {
        viewModel.loadMessages("")
    }

    LaunchedEffect(messages.size) {
        lazyListState.animateScrollToItem(messages.size)
    }

    Scaffold(
        topBar = {
            ChatTopBar(
                avatarUrl = "",
                nickname = "Dima",
                onAvatarClick = { onAvatarClick() },
                onNavigationIconClick = { onNavigationIconClick() }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color.White, Purple80)
                    )
                )
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(12f)
                    .imePadding(),
                state = lazyListState,
                verticalArrangement = Arrangement.Bottom
            ) {
                items(messages.size) {
                    ChatItem(
                        message = messages[it],
                        modifier = Modifier
                            .animateItemPlacement(),
                        position = MessagePosition.END
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                ChatTextField(
                    value = viewModel.typedMessage,
                    modifier = Modifier
                        .weight(8f)
                )

                Image(
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = "",
                    modifier = Modifier
                        .size(42.dp)
                        .weight(1f)
                        .clickable {
                            viewModel.sendMessage(viewModel.typedMessage.value)
                            viewModel.clearTextView()
                        }
                )
            }
        }
    }
}

@Composable
@Preview
private fun ChatScreenPreview() {

    ChatTheme {
        ChatScreen(
            onAvatarClick = {},
            onNavigationIconClick = {}
        )
    }
}