package com.alph.studioghibli.di

import com.alph.studioghibli.data.repository.FilmRepositoryImpl
import com.alph.studioghibli.domain.repository.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindFilmRepository(filmRepositoryImpl: FilmRepositoryImpl): FilmRepository

}