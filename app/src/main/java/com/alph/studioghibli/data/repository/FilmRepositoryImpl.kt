package com.alph.studioghibli.data.repository

import com.alph.studioghibli.data.remote.FilmApi
import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films
import com.alph.studioghibli.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val api: FilmApi
) : FilmRepository {
    override suspend fun getAllFilms(): List<Films> {
        return api.getAllFilms()
    }

    override suspend fun getFilmById(filmId: String): FilmDetail {
        return api.getFilmById(filmId)
    }
}