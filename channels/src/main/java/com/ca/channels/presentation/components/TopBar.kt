package com.ca.channels.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ca.core.presentation.components.Avatar
import com.ca.core.presentation.theme.ChatTheme
import com.ca.core.presentation.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChannelsTopBar() {
    TopAppBar(
        title = { Text(text = "Fire Chat", fontSize = 18.sp, color = Theme.colors.onSurface) },
        modifier = Modifier
            .shadow(4.dp),
        navigationIcon = {
             IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Icon",
                    tint = Theme.colors.onSurface
                )
             }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Theme.colors.surface
        )
    )
}



@Composable
@Preview
private fun HomeTopBarPreview() {
    ChatTheme {
        ChannelsTopBar()
    }
}

