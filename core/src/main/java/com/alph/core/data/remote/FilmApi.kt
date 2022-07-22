package com.alph.core.data.remote

import com.alph.core.data.remote.model.FilmDetail
import com.alph.core.data.remote.model.Films
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {
    @GET("films")
    suspend fun getAllFilms() : List<Films>

    @GET("films/{filmId}")
    suspend fun getFilmById(@Path("filmId") id: String) : FilmDetail

}