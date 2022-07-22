package com.alph.core.data.repository

import com.alph.core.data.local.room.FavoriteFilmsDao
import com.alph.core.data.remote.FilmApi
import com.alph.core.data.remote.model.FilmDetail
import com.alph.core.data.remote.model.Films
import com.alph.core.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val api: FilmApi,
) : FilmRepository {
    override suspend fun getAllFilms(): List<Films> {
        return api.getAllFilms()
    }

    override suspend fun getFilmById(filmId: String): FilmDetail {
        return api.getFilmById(filmId)
    }
}