package com.alph.core.domain.use_case.delete_fav_film

import com.alph.core.domain.repository.FavoriteFilmRepository
import javax.inject.Inject

class DeleteFavFilmUseCase @Inject constructor(
    private val repository: FavoriteFilmRepository
) {

    suspend operator fun invoke(film: com.alph.core.data.local.entity.FilmEntity) {
        repository.deleteFavoriteFilm(film)
    }
}