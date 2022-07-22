package com.alph.studioghibli.presentation.film_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alph.core.common.Resources
import com.alph.core.domain.use_case.get_films.GetFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val getFilmsUseCase: GetFilmsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(FilmListState())
    val state: State<FilmListState> = _state

    init {
        getAllFilms()
    }

    private fun getAllFilms() {
        getFilmsUseCase().onEach { result ->
            when(result) {
                is Resources.Success -> {
                    _state.value = FilmListState(films = result.data ?: emptyList())
                }
                is Resources.Error -> {
                    _state.value = FilmListState(error = result.message ?: "An unexpected error has occurred")
                }
                is Resources.Loading -> {
                    _state.value = FilmListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}