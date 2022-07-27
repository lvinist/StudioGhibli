package com.alph.favorites.presentation.favorite_film

import androidx.lifecycle.*
import com.alph.core.data.local.entity.FilmEntity
import com.alph.core.domain.use_case.get_fav_film.GetFavFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmFavoriteViewModel @Inject constructor(
    private val getFavFilmUseCase: GetFavFilmUseCase
) : ViewModel() {

    fun getFavFilm(): LiveData<List<FilmEntity>> = getFavFilmUseCase.invoke().asLiveData()

}