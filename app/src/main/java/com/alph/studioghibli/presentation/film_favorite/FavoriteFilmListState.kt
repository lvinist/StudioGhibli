package com.alph.studioghibli.presentation.film_favorite

import com.alph.core.data.local.entity.FilmEntity

data class FavoriteFilmListState(
    val films: List<FilmEntity> = emptyList()
)