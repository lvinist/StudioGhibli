package com.alph.studioghibli.domain.use_case.get_fav_film

import com.alph.studioghibli.data.local.entity.FilmEntity
import com.alph.studioghibli.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    operator fun invoke() : Flow<List<FilmEntity>> {
        return repository.getFavoriteFilm()
    }
}