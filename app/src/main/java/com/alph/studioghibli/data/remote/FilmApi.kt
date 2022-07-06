package com.alph.studioghibli.data.remote

import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmApi {
    @GET("films")
    suspend fun getAllFilms() : List<Films>

    @GET("films/{id}")
    suspend fun getFilmById(@Path("id") id: String) : FilmDetail

}