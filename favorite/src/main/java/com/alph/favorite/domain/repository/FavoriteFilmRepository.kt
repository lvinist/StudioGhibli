package com.alph.favorite.domain.repository

import kotlinx.coroutines.flow.Flow

interface FavoriteFilmRepository {

    //database function
    suspend fun addFavoriteFilm(film: com.alph.core.data.local.entity.FilmEntity)

    fun getFavoriteFilm() : Flow<List<com.alph.core.data.local.entity.FilmEntity>>

    suspend fun checkFavoriteFilm(filmId: String) : Boolean

    suspend fun deleteFavoriteFilm(film: com.alph.core.data.local.entity.FilmEntity)
}