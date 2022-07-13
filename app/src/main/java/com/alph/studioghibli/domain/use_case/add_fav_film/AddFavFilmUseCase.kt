package com.alph.studioghibli.domain.use_case.add_fav_film

import com.alph.studioghibli.domain.dto.FilmDto
import com.alph.studioghibli.domain.repository.FilmRepository
import javax.inject.Inject

class AddFavFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    suspend operator fun invoke(filmDto: FilmDto) {
        repository.addFavoriteFilm(filmDto)
    }
}