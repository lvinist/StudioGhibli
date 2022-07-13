package com.alph.studioghibli.data.repository

import com.alph.studioghibli.data.local.FavoriteFilmsDao
import com.alph.studioghibli.data.remote.FilmApi
import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films
import com.alph.studioghibli.domain.dto.FilmDto
import com.alph.studioghibli.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val api: FilmApi,
    private val dao: FavoriteFilmsDao
) : FilmRepository {
    override suspend fun getAllFilms(): List<Films> {
        return api.getAllFilms()
    }

    override suspend fun getFilmById(filmId: String): FilmDetail {
        return api.getFilmById(filmId)
    }

    override suspend fun addFavoriteFilm(filmDto: FilmDto) {
        dao.insertFavFilm(filmDto)
    }

    override suspend fun getFavoriteFilm(): Flow<List<FilmDto>> {
        return dao.getAllFavFilm()
    }

    override suspend fun deleteFavoriteFilm(filmDto: FilmDto) {
        dao.deleteFavFilm(filmDto)
    }
}