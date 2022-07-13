package com.alph.studioghibli.domain.use_case.add_fav_film

import com.alph.studioghibli.domain.dto.FilmDto
import com.alph.studioghibli.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavFilmUseCase @Inject constructor(
    private val repository: FilmRepository
) {

    suspend operator fun invoke() : Flow<List<FilmDto>> {
        return repository.getFavoriteFilm()
    }
}