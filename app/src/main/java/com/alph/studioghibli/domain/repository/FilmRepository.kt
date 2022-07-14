package com.alph.studioghibli.domain.repository

import com.alph.studioghibli.data.local.entity.FilmEntity
import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    //api request
    suspend fun getAllFilms() : List<Films>

    suspend fun getFilmById(filmId: String) : FilmDetail

    //database function
    suspend fun addFavoriteFilm(film: FilmEntity)

    fun getFavoriteFilm() : Flow<List<FilmEntity>>

    suspend fun deleteFavoriteFilm(film: FilmEntity)
}