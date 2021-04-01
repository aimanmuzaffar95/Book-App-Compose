package com.aiman.bookreadingcompose.ui.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.aiman.bookreadingcompose.R

object Favourites {
    @Composable
    fun FavouritesTab() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.background_dark))
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 12.dp,
                    end = 12.dp
                ),
            ) {
                Text("Favourites Tab", color = Color.White)
            }
        }
    }
}