package com.alph.githubsearch.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alph.studioghibli.data.local.FavoriteFilmsDao

@Database(entities = [FavoriteFilmsDao::class], version = 1)
abstract class FilmsDatabase : RoomDatabase() {
    companion object{
        @Volatile
        private var INSTANCE : FilmsDatabase? = null

        @JvmStatic
        fun getDatabase(ctx: Context): FilmsDatabase {
            if (INSTANCE == null) {
                synchronized(FilmsDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(ctx.applicationContext, FilmsDatabase::class.java, "favorite_film_database")
                        .build()
                }
            }
            return INSTANCE as FilmsDatabase
        }
    }

    abstract fun favoriteFilmsDao(): FavoriteFilmsDao
}