package com.alph.core.di

import android.app.Application
import androidx.room.Room
import com.alph.core.data.local.room.FilmsDatabase
import com.alph.core.data.remote.FilmApi
import com.alph.core.data.repository.FilmRepositoryImpl
import com.alph.core.domain.repository.FilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): FilmsDatabase {
        return Room.databaseBuilder(
            app,
            FilmsDatabase::class.java,
            FilmsDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFilmRepository(api: FilmApi): FilmRepository {
        return FilmRepositoryImpl(api)
    }
}