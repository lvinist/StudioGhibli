package com.alph.favorite.domain.use_case.get_fav_film

import com.alph.core.domain.repository.FilmRepository
import com.alph.favorite.domain.repository.FavoriteFilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavFilmUseCase @Inject constructor(
    private val repository: FavoriteFilmRepository
) {

    operator fun invoke() : Flow<List<com.alph.core.data.local.entity.FilmEntity>> {
        return repository.getFavoriteFilm()
    }
}