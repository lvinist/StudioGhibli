package com.alph.studioghibli.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alph.studioghibli.presentation.film_detail.FilmDetailScreen
import com.alph.studioghibli.presentation.film_favorite.FilmFavoriteScreen
import com.alph.studioghibli.presentation.film_list.FilmListScreen
import com.alph.studioghibli.presentation.settings.SettingsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.FilmListScreen.route
    ) {
        composable(
            route = Screens.FilmListScreen.route
        ) {
            FilmListScreen(navController)
        }
        composable(
            route = Screens.FilmFavoriteScreen.route
        ) {
            FilmFavoriteScreen(navController)
        }
        composable(
            route = Screens.SettingsScreen.route
        ) {
            SettingsScreen()
        }
        composable(
            route = Screens.FilmDetailScreen.route + "/{filmId}"
        ) {
            FilmDetailScreen()
        }
    }
}