package com.ca.chat.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ca.core.presentation.components.Avatar
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun ChatTopBar(
    avatarUrl: String,
    nickname: String,
    onAvatarClick: () -> Unit,
    onNavigationIconClick: () -> Unit
) {
    Surface(
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = { onNavigationIconClick() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = Theme.colors.onSurface
                )
            }
            Avatar(
                modifier = Modifier
                    .size(48.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { onAvatarClick() }
            )
            Text(text = nickname, fontSize = 18.sp, color = Theme.colors.onSurface)
        }
    }

}

@Composable
@Preview
private fun ChatTopBarPreview() {
    ChatTheme {
        ChatTopBar(avatarUrl = "", nickname = "Dima", onAvatarClick = { /*TODO*/ }) {

        }
    }
}