package com.ca.core.presentation.components

import androidx.compose.foundation.Image
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

@Composable
fun Avatar() {
    Image(
        painter = painterResource(id = R.drawable.cat),
        contentDescription = "",
        modifier = Modifier
            .size(70.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview
private fun AvatarPreview() {
    Box(
        modifier = Modifier
            .size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Avatar()
    }
}