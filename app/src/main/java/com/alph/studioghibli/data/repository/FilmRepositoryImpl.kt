package com.alph.studioghibli.data.repository

import com.alph.studioghibli.data.local.entity.FilmEntity
import com.alph.studioghibli.data.local.room.FavoriteFilmsDao
import com.alph.studioghibli.data.remote.FilmApi
import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films
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

    override suspend fun addFavoriteFilm(film: FilmEntity) {
        return dao.insertFavFilm(film)
    }

    override fun getFavoriteFilm(): Flow<List<FilmEntity>> {
        return dao.getAllFavFilm()
    }

    override suspend fun deleteFavoriteFilm(film: FilmEntity) {
        return dao.deleteFavFilm(film)
    }
}