package com.alph.studioghibli.domain.use_case.get_films

import com.alph.studioghibli.common.Resources
import com.alph.studioghibli.data.remote.model.toFilmDto
import com.alph.studioghibli.domain.dto.FilmDto
import com.alph.studioghibli.domain.repository.FilmRepository
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
            emit(Resources.Loading())
            val films = filmRepository.getAllFilms().map { it.toFilmDto() }
            emit(Resources.Success(films))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resources.Error("Couldn't reach server, please check your internet connection"))
        }
    }
}