package com.alph.studioghibli.presentation

sealed class Screen(val route: String) {
    object FilmListScreen: Screen("film_list_screen")
    object FilmDetailScreen: Screen("film_detail_screen")
}