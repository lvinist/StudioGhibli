package com.alph.studioghibli.presentation.film_detail

import com.alph.core.domain.dto.FilmDetailDto

data class FilmDetailState(
    val isLoading: Boolean = false,
    val filmDetail: FilmDetailDto? = null,
    val error: String = "",
)