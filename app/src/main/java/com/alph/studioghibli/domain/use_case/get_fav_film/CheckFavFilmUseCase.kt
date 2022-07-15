package com.alph.studioghibli.domain.use_case.get_fav_film

import com.alph.studioghibli.domain.repository.FilmRepository
import javax.inject.Inject

class CheckFavFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    suspend operator fun invoke(filmId: String) : Boolean {
        return repository.checkFavoriteFilm(filmId)
    }
}