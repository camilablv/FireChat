package com.ca.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.R
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun Avatar(
    modifier: Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.cat),
        contentDescription = "",
        modifier = modifier
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
private fun AvatarPreview() {
    ChatTheme {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Theme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Avatar(
                modifier = Modifier
                    .size(70.dp)
            )
        }
    }
}