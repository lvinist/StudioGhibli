package com.alph.favorite.domain.use_case.add_fav_film

import com.alph.core.domain.repository.FilmRepository
import com.alph.favorite.domain.repository.FavoriteFilmRepository
import javax.inject.Inject

class AddFavFilmUseCase @Inject constructor(
    private val repository: FavoriteFilmRepository
) {

    suspend operator fun invoke(film: com.alph.core.data.local.entity.FilmEntity) {
        repository.addFavoriteFilm(film)
    }
}