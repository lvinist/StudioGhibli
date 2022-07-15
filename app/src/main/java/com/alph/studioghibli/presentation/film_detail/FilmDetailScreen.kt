package com.alph.studioghibli.presentation.film_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.alph.studioghibli.data.local.entity.FilmEntity
import com.alph.studioghibli.domain.dto.FilmDetailDto
import com.alph.studioghibli.presentation.film_detail.components.MovieDetailsTopBar

@Composable
fun FilmDetailScreen(
    viewModel: FilmDetailViewModel = hiltViewModel(),
    upPressed: () -> Unit
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            MovieDetailsTopBar(
                title = state.filmDetail?.title ?: "",
                isFavorite = viewModel.isFavorite == true,
                isFavoriteLoading = state.isLoading,
                onFavoriteClicked = {
                    viewModel.onFavoriteClicked(
                        FilmEntity(
                            id = state.filmDetail?.id.toString(),
                            title = state.filmDetail?.title.toString(),
                            releaseDate = state.filmDetail?.releaseDate.toString(),
                            image = state.filmDetail?.image.toString()
                        )
                    )
                },
                upPressed = upPressed
            )
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {

            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            state.filmDetail?.let { film ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16 / 9f)
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black
                                    ),
                                    startY = 100f,

                                    )
                            ),
                        contentAlignment = Alignment.Center,

                        ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = film.movieBanner),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize(),
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .offset(y = -100.dp), verticalAlignment = Alignment.Bottom
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = film.image),
                            contentDescription = "",
                            modifier = Modifier
                                .aspectRatio(2 / 3f)
                                .weight(2f)
                                .shadow(20.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                        MovieInfo(
                            film = film, modifier = Modifier
                                .padding(10.dp, 0.dp)
                                .weight(4f)
                        )
                    }
                    Text(
                        text = "Produced by ${film.producer}\nDirected by ${film.director}\n\n${film.description}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(16.dp).offset(y = -100.dp),
                        textAlign = TextAlign.Justify
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
private fun MovieInfo(
    film: FilmDetailDto,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = film.title ?: "",
            style = androidx.compose.material.MaterialTheme.typography.h5,
        )
        Text(
            text = film.originalTitle ?: "",
            style = androidx.compose.material.MaterialTheme.typography.h6
        )
        Text(
            text = "Released on ${film.releaseDate} • ${film.runningTime} Minutes",
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic
        )
    }

}

