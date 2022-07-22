package com.alph.core.domain.repository


interface FilmRepository {

    //api request
    suspend fun getAllFilms() : List<com.alph.core.data.remote.model.Films>

    suspend fun getFilmById(filmId: String) : com.alph.core.data.remote.model.FilmDetail

}