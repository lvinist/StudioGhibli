package com.alph.core.data.local.room

import androidx.room.*
import com.alph.core.data.local.entity.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteFilmsDao {

    @Query("SELECT * FROM filmentity")
    fun getAllFavFilm(): Flow<List<FilmEntity>>

    @Query("SELECT EXISTS(SELECT * FROM filmentity WHERE id = :filmId)")
    suspend fun checkFavoriteFilm(filmId: String) :Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavFilm(filmEntity: FilmEntity)

    @Delete
    suspend fun deleteFavFilm(filmEntity: FilmEntity)

}