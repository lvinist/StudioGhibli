package com.alph.studioghibli.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alph.studioghibli.data.local.entity.FilmEntity

@Database(entities = [FilmEntity::class], version = 1, exportSchema = false)
abstract class FilmsDatabase : RoomDatabase() {
    abstract fun favoriteFilmDao(): FavoriteFilmsDao

    companion object {
        const val DATABASE_NAME = "film_database"
    }
}