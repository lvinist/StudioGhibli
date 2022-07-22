package com.alph.studioghibli.presentation.film_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alph.core.common.Resources
import com.alph.core.domain.use_case.get_film_detail.GetFilmDetailUseCase
import com.alph.favorite.domain.use_case.add_fav_film.AddFavFilmUseCase
import com.alph.favorite.domain.use_case.delete_fav_film.DeleteFavFilmUseCase
import com.alph.favorite.domain.use_case.get_fav_film.CheckFavFilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmDetailViewModel @Inject constructor(
    private val getFilmDetailUseCase: GetFilmDetailUseCase,
    private val addFavFilmUseCase: AddFavFilmUseCase,
    private val deleteFavFilmUseCase: DeleteFavFilmUseCase,
    private val checkFavFilmUseCase: CheckFavFilmUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(FilmDetailState())
    val state: State<FilmDetailState> = _state

    var isFavorite: Boolean? by mutableStateOf(null)
    private var isFavLoading : Boolean by mutableStateOf(false)

    init {
        savedStateHandle.get<String>(com.alph.core.common.Constants.PARAM_FILM_ID)?.let { filmId ->
            checkFavFilm(filmId)
            getFilmsById(filmId)
        }
    }

    private fun getFilmsById(filmId: String) {
        getFilmDetailUseCase(filmId).onEach { result ->
            when(result) {
                is Resources.Success<*> -> {
                    _state.value = FilmDetailState(filmDetail = result.data)
                }
                is Resources.Error<*> -> {
                    _state.value = FilmDetailState(error = result.message ?: "An unexpected error has occurred")
                }
                is Resources.Loading<*> -> {
                    _state.value = FilmDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun checkFavFilm(filmId: String) {
        viewModelScope.launch {
            isFavLoading = true
            if (checkFavFilmUseCase(filmId)) {
                isFavorite = true
                isFavLoading = false
            }
            isFavLoading = false
        }
    }

    fun onFavoriteClicked(film: com.alph.core.data.local.entity.FilmEntity) {
        viewModelScope.launch {
            isFavLoading = true
            isFavorite = if (isFavorite == true) {
                deleteFavFilmUseCase(film)
                false
            } else {
                addFavFilmUseCase(film)
                true
            }

        }
    }
}