package com.alph.studioghibli.domain.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FilmDto(
    @PrimaryKey
    val id: String? = null,
    val title: String? = null,
    val releaseDate: String? = null,
)
