package com.ca.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ca.core.presentation.theme.Theme

@Composable
fun NewMessagesCount(
    count: Int? = null
) {
    if (count == null) return
    Text(
        text = count.toString(),
        modifier = Modifier
            .background(Theme.colors.primary, CircleShape)
            .size(24.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}