package com.alph.core.domain.use_case.get_fav_film

import com.alph.core.data.local.entity.FilmEntity
import com.alph.core.domain.repository.FavoriteFilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavFilmUseCase @Inject constructor(
    private val repository: FavoriteFilmRepository
) {

    operator fun invoke() : Flow<List<FilmEntity>> {
        return repository.getFavoriteFilm()
    }
}