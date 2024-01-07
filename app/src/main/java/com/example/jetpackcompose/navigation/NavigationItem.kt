package com.example.jetpackcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpackcompose.R

sealed class NavigationItem(
    val screen: Screen, val titleResId: Int, val icon: ImageVector
) {
    object Home : NavigationItem(
        screen = Screen.Home, titleResId = R.string.navigation_item_main, icon = Icons.Filled.Home
    )

    object Favorite : NavigationItem(
        screen = Screen.Favourite, titleResId = R.string.navigation_item_favorite, icon = Icons.Filled.Favorite
    )

    object Profile : NavigationItem(
        screen = Screen.Profile, titleResId = R.string.navigation_item_profile, icon = Icons.Filled.Person
    )
}