package com.aiman.bookreadingcompose.utils

import androidx.compose.ui.graphics.Color

fun getComposeColor(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}