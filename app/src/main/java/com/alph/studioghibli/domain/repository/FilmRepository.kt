package com.alph.studioghibli.domain.repository

import com.alph.studioghibli.data.remote.model.FilmDetail
import com.alph.studioghibli.data.remote.model.Films

interface FilmRepository {

    suspend fun getAllFilms() : List<Films>

    suspend fun getFilmById(filmId: String) : FilmDetail
}