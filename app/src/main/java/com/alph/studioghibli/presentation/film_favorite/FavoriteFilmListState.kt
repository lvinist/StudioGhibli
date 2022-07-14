package com.alph.studioghibli.presentation.film_favorite

import com.alph.studioghibli.data.local.entity.FilmEntity

data class FavoriteFilmListState(
    val films: List<FilmEntity> = emptyList()
)