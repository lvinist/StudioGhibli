package com.alph.studioghibli.domain.repository

import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films
import com.alph.studioghibli.domain.dto.FilmDto
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    //api request
    suspend fun getAllFilms() : List<Films>

    suspend fun getFilmById(filmId: String) : FilmDetail

    //database function
    suspend fun addFavoriteFilm(filmDto: FilmDto)

    suspend fun getFavoriteFilm() : Flow<List<FilmDto>>

    suspend fun deleteFavoriteFilm(filmDto: FilmDto)
}