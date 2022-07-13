package com.alph.studioghibli.presentation.film_favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alph.studioghibli.domain.use_case.add_fav_film.GetFavFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmFavoriteViewModel @Inject constructor(
    private val getFavFilmUseCase: GetFavFilmUseCase
) : ViewModel() {
    private val _state = mutableStateOf(FavoriteFilmListState())
    val state: State<FavoriteFilmListState> = _state

    init {
        getFavFilm()
    }

    private fun getFavFilm() {
        viewModelScope.launch {
            getFavFilmUseCase().onEach { result ->
                _state.value = FavoriteFilmListState(films = result)
            }
        }
    }
}