package com.ca.core.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = FireChatTypography(
    headerMiddle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 33.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )
)

data class FireChatTypography(
    val headerMiddle: TextStyle,
    val bodyLarge: TextStyle,
)

val LocalFireChatTypography = staticCompositionLocalOf<FireChatTypography> {
    error("No FireChatTypography Provided")
}