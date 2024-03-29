package com.alph.core.domain.use_case.get_fav_film

import com.alph.core.domain.repository.FavoriteFilmRepository
import javax.inject.Inject

class CheckFavFilmUseCase @Inject constructor(
    private val repository: FavoriteFilmRepository
) {

    suspend operator fun invoke(filmId: String) : Boolean {
        return repository.checkFavoriteFilm(filmId)
    }
}