package com.ca.channels.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.ChatTheme
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.placeholder

@Composable
fun ChannelsLoadingFadeAnimation(
    isVisible: Boolean
) {
    if (!isVisible) return
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        repeat(10) {
            ChannelsFadeAnimationItem()
        }
    }
}

@Composable
fun ChannelsFadeAnimationItem() {
    Row(
        modifier = Modifier
            .height(75.dp)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.White, CircleShape)
                .size(70.dp)
                .placeholder(
                    visible = true,
                    highlight = PlaceholderHighlight.fade(Color(0xFFC7CCCC)),
                    color = Color(0xFFB1B4B4),
                    shape = RoundedCornerShape(50)
                )
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(16.dp)
                    .placeholder(
                        visible = true,
                        highlight = PlaceholderHighlight.fade(Color(0xFFC7CCCC)),
                        color = Color(0xFFB1B4B4),
                        shape = RoundedCornerShape(50)
                    )
            )

            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(16.dp)
                    .placeholder(
                        visible = true,
                        highlight = PlaceholderHighlight.fade(Color(0xFFC7CCCC)),
                        color = Color(0xFFB1B4B4),
                        shape = RoundedCornerShape(50)
                    )
            )
        }
    }
}

@Composable
@Preview
private fun ChannelsLoadingFadeAnimationPreview() {
    ChatTheme {
        ChannelsLoadingFadeAnimation(isVisible = true)
    }
}