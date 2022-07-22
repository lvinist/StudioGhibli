package com.alph.core.domain.use_case.get_films

import com.alph.core.common.Resources
import com.alph.core.data.remote.model.toFilmDto
import com.alph.core.domain.dto.FilmDto
import com.alph.core.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {
    operator fun invoke() : Flow<Resources<List<FilmDto>>> = flow {
        try {
            emit(Resources.Loading<List<FilmDto>>())
            val films = filmRepository.getAllFilms().map { it.toFilmDto() }
            emit(Resources.Success<List<FilmDto>>(films))
        } catch (e: HttpException) {
            emit(Resources.Error<List<FilmDto>>(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resources.Error<List<FilmDto>>("Couldn't reach server, please check your internet connection"))
        }
    }
}