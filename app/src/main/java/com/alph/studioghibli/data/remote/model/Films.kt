package com.alph.studioghibli.data.remote.model

import com.alph.studioghibli.domain.dto.FilmDto
import com.squareup.moshi.Json

data class Films(

	@Json(name="original_title")
	val originalTitle: String? = null,

	@Json(name="director")
	val director: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="vehicles")
	val vehicles: List<String?>? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="rt_score")
	val rtScore: String? = null,

	@Json(name="people")
	val people: List<String?>? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="release_date")
	val releaseDate: String? = null,

	@Json(name="species")
	val species: List<String?>? = null,

	@Json(name="original_title_romanised")
	val originalTitleRomanised: String? = null,

	@Json(name="producer")
	val producer: String? = null,

	@Json(name="running_time")
	val runningTime: String? = null,

	@Json(name="locations")
	val locations: List<String?>? = null,

	@Json(name="id")
	val id: String? = null
)

fun Films.toFilmDto() : FilmDto {
	return FilmDto(
		id = id,
		title = title,
		releaseDate = releaseDate
	)
}