package com.alph.favorite.data.repository

import com.alph.core.data.local.entity.FilmEntity
import com.alph.core.data.local.room.FavoriteFilmsDao
import com.alph.core.data.remote.FilmApi
import com.alph.favorite.domain.repository.FavoriteFilmRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteFilmRepositoryImpl @Inject constructor(
    private val dao: FavoriteFilmsDao
) : FavoriteFilmRepository {

    override suspend fun addFavoriteFilm(film: FilmEntity) {
        return dao.insertFavFilm(film)
    }

    override fun getFavoriteFilm(): Flow<List<FilmEntity>> {
        return dao.getAllFavFilm()
    }

    override suspend fun checkFavoriteFilm(filmId: String) : Boolean {
        return dao.checkFavoriteFilm(filmId)
    }

    override suspend fun deleteFavoriteFilm(film: FilmEntity) {
        return dao.deleteFavFilm(film)
    }
}