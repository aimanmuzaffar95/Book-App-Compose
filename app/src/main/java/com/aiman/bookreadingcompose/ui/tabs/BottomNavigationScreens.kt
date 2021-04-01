package com.aiman.bookreadingcompose.ui.tabs

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.aiman.bookreadingcompose.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : BottomNavigationScreens("Home", R.string.home, Icons.Filled.Home)
    object Browse : BottomNavigationScreens("Browse", R.string.browse, Icons.Filled.Search)
    object Favourites : BottomNavigationScreens("Ghost", R.string.favourites, Icons.Filled.Favorite)
    object Cart : BottomNavigationScreens("Cart", R.string.cart, Icons.Filled.ShoppingCart)
}