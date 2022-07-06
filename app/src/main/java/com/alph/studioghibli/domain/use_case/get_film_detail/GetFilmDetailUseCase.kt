package com.alph.studioghibli.domain.use_case.get_film_detail

import com.alph.studioghibli.common.Resources
import com.alph.studioghibli.data.remote.model.toFilmDetailDto
import com.alph.studioghibli.domain.dto.FilmDetailDto
import com.alph.studioghibli.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFilmDetailUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {
    operator fun invoke(filmId: String) : Flow<Resources<FilmDetailDto>> = flow {
        try {
            emit(Resources.Loading())
            val filmDetail = filmRepository.getFilmById(filmId).toFilmDetailDto()
            emit(Resources.Success(filmDetail))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resources.Error("Couldn't reach server, please check your internet connection"))
        }
    }
}