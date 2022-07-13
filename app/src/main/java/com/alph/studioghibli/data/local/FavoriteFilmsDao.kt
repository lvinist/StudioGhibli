package com.alph.studioghibli.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.alph.studioghibli.domain.dto.FilmDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteFilmsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavFilm(filmDto: FilmDto)

    @Delete
    suspend fun deleteFavFilm(filmDto: FilmDto)

    @Query("SELECT * FROM filmdto")
    fun getAllFavFilm(): Flow<List<FilmDto>>
}