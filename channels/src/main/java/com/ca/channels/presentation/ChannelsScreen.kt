package com.ca.channels.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ca.channels.domain.model.Channel
import com.ca.channels.presentation.components.ChannelsItem
import com.ca.channels.presentation.components.ChannelsLoadingFadeAnimation
import com.ca.channels.presentation.components.ChannelsTopBar
import com.ca.core.presentation.theme.ChatTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChannelsScreen(
    viewModel: ChannelsViewModelImpl = koinViewModel(),
    navigateToChannel: (Channel) -> Unit
) {
    val viewState by viewModel.viewState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(true) {
        viewModel.channels()
    }
    
    Scaffold(
        topBar = { ChannelsTopBar() },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            ChannelsLoadingFadeAnimation(isVisible = viewState.loading)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(viewState.channels.size) {
                    ChannelsItem(
                        channel = viewState.channels[it],
                        onClick = navigateToChannel
                    )
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