package com.alph.studioghibli.data.local.room

import androidx.room.*
import com.alph.studioghibli.data.local.entity.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteFilmsDao {

    @Query("SELECT * FROM filmentity")
    fun getAllFavFilm(): Flow<List<FilmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavFilm(filmEntity: FilmEntity)

    @Delete
    suspend fun deleteFavFilm(filmEntity: FilmEntity)

}