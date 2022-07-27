package com.alph.favorites.presentation.favorite_film

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alph.core.data.local.entity.FilmEntity
import com.alph.core.domain.dto.FilmDto
import com.alph.favorites.databinding.ActivityFavoriteFilmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFilmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteFilmBinding
    private lateinit var adapter: FavoriteFilmAdapter
    private lateinit var viewModel: FilmFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FavoriteFilmAdapter()
        adapter.notifyDataSetChanged()

        viewModel = ViewModelProvider(this).get(FilmFavoriteViewModel::class.java)

        binding.apply {
            rvFilms.setHasFixedSize(true)
            rvFilms.layoutManager = LinearLayoutManager(this@FavoriteFilmActivity)
            rvFilms.adapter = adapter
        }

        viewModel.getFavFilm().observe(this) {
            if (it != null) {
                val list = mapList(it)
                adapter.setList(list)
            }
        }
    }

    private fun mapList(films: List<FilmEntity>): ArrayList<FilmDto> {
        val listFilm = ArrayList<FilmDto>()
        for (film in films) {
            val filmMapped = FilmDto(
                film.id,
                film.title,
                film.releaseDate,
                film.image
            )
            listFilm.add(filmMapped)
        }
        return listFilm
    }
}