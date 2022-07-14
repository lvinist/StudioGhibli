package com.alph.studioghibli.domain.dto

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


data class FilmDto(
    val id: String? = null,
    val title: String? = null,
    val releaseDate: String? = null,
)
