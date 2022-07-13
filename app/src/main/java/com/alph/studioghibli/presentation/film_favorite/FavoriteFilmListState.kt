package com.alph.studioghibli.presentation.film_favorite

import com.alph.studioghibli.domain.dto.FilmDto

data class FavoriteFilmListState(
    val films: List<FilmDto> = emptyList()
)