package com.alph.core.di

import com.alph.core.data.local.room.FilmsDatabase
import com.alph.core.data.repository.FavoriteFilmRepositoryImpl
import com.alph.core.domain.repository.FavoriteFilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {

    @Provides
    @Singleton
    fun provideFavoriteFilmRepository(db: FilmsDatabase): FavoriteFilmRepository {
        return FavoriteFilmRepositoryImpl(db.favoriteFilmDao())
    }
}