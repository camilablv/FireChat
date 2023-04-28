package com.ca.core.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun ChatTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

//    val view = LocalView.current
//    val window = (view.context as? Activity)?.window
//        ?: throw Exception("Not in an activity - unable to get Window reference")
//    if (!view.isInEditMode) {
//        SideEffect {
//            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }

    CompositionLocalProvider(
        LocalFireChatColors provides colorScheme,
        LocalFireChatTypography provides Typography,
        LocalFireChatShapes provides Shapes,
        content = content
    )
}

object Theme {
    val colors: FireChatColors
        @Composable
        get() = LocalFireChatColors.current

    val typography: FireChatTypography
        @Composable
        get() = LocalFireChatTypography.current

    val shapes: FireChatShapes
        @Composable
        get() = LocalFireChatShapes.current
}