package com.alph.studioghibli.presentation.film_favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alph.studioghibli.presentation.film_favorite.components.FavoriteFilmListItem
import com.alph.studioghibli.presentation.navigation.Screens

@Composable
fun FilmFavoriteScreen(
    navController: NavController,
    viewModel: FilmFavoriteViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.films) { film ->
                FavoriteFilmListItem(filmEntity = film, onItemClick = {
                    navController.navigate(Screens.FilmDetailScreen.route + "/${film.id}")
                } )
            }
        }
    }
}