package com.alph.studioghibli.presentation.film_detail

import com.alph.studioghibli.domain.dto.FilmDetailDto
import com.alph.studioghibli.domain.dto.FilmDto

data class FilmDetailState(
    val isLoading: Boolean = false,
    val filmDetail: FilmDetailDto? = null,
    val error: String = "",
)