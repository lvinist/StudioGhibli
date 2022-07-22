package com.alph.studioghibli.presentation.film_favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.alph.core.domain.dto.FilmDto
import com.alph.studioghibli.presentation.common.components.MovieCard
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun FilmFavoriteScreen(
    navController: NavController,
    viewModel: FilmFavoriteViewModel = hiltViewModel()
) {
    val scaffoldState = rememberCollapsingToolbarScaffoldState()
    val state = viewModel.state.value

    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = scaffoldState,
        scrollStrategy = ScrollStrategy.EnterAlwaysCollapsed,
        toolbar = {
            val textSize = (18 + (30 - 12) * scaffoldState.toolbarState.progress).sp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .pin()
            )
            Text(
                "Favorite Film",
                style = TextStyle(fontSize = textSize),
                modifier = Modifier
                    .padding(16.dp)
                    .road(
                        whenCollapsed = Alignment.TopCenter,
                        whenExpanded = Alignment.BottomCenter
                    ),
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(10.dp)
            ) {
                items(state.films) { film ->
                    MovieCard(
                        modifier = Modifier,
                        films = FilmDto(
                            film.id,
                            film.title,
                            film.releaseDate,
                            film.image
                        ),
                        painter = rememberAsyncImagePainter(
                            model = film.image,
                        ),
                        navController
                    )
                }
            }
            if (state.films.isEmpty()) {
                Text(
                    text = "Hey, Let's like some of our movies!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }


}