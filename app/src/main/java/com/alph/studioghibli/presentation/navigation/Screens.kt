package com.alph.studioghibli.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null,
) {
    object FilmListScreen: Screens(
        route = "film_list_screen",
        title = "Home",
        icon = Icons.Default.Home,
    )
    object FilmFavoriteScreen: Screens(
        route = "film_Favorite_screen",
        title = "Favorite",
        icon = Icons.Default.Favorite,
    )
    object SettingsScreen: Screens(
        route = "settings_screen",
        title = "Settings",
        icon = Icons.Default.Settings,
    )
    object FilmDetailScreen: Screens("film_detail_screen")
}