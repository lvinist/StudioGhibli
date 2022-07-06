package com.alph.studioghibli.presentation.film_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alph.studioghibli.common.Constants
import com.alph.studioghibli.common.Resources
import com.alph.studioghibli.domain.use_case.get_film_detail.GetFilmDetailUseCase
import com.alph.studioghibli.domain.use_case.get_films.GetFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FilmDetailViewModel @Inject constructor(
    private val getFilmDetailUseCase: GetFilmDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(FilmDetailState())
    val state: State<FilmDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_FILM_ID)?.let { filmId ->
            getFilmsById(filmId)
        }
    }

    private fun getFilmsById(filmId: String) {
        getFilmDetailUseCase(filmId).onEach { result ->
            when(result) {
                is Resources.Success -> {
                    _state.value = FilmDetailState(filmDetail = result.data)
                }
                is Resources.Error -> {
                    _state.value = FilmDetailState(error = result.message ?: "An unexpected error has occurred")
                }
                is Resources.Loading -> {
                    _state.value = FilmDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}