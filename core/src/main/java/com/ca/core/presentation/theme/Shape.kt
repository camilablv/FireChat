package com.ca.core.presentation.theme

import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = FireChatShapes(
    button = RoundedCornerShape(50),
    card = AbsoluteRoundedCornerShape(8.dp),
    textField = RoundedCornerShape(50.dp),
    navigationDrawer = CutCornerShape(0.dp),

)

data class FireChatShapes(
    val button: Shape,
    val card: Shape,
    val textField: Shape,
    val navigationDrawer: Shape,
)



val LocalFireChatShapes = staticCompositionLocalOf<FireChatShapes> {
    error("No FireChatShapes Provided")
}