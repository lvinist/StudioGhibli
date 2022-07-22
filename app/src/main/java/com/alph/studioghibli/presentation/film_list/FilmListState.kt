package com.alph.studioghibli.presentation.film_list

import com.alph.core.domain.dto.FilmDto

data class FilmListState(
    val isLoading: Boolean = false,
    val films: List<FilmDto> = emptyList(),
    val error: String = ""
)