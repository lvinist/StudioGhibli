package com.alph.studioghibli.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alph.studioghibli.domain.dto.FilmDto
import com.alph.studioghibli.presentation.navigation.Screens

@Composable
fun MovieCard(
    modifier: Modifier,
    films: FilmDto,
    painter: Painter,
    navController : NavController
) {
    Card(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(10.dp)
            .clickable { navController.navigate(Screens.FilmDetailScreen.route + "/${films.id}") },
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Box(Modifier.aspectRatio(0.66f)) {
            Image(
                painter = painter,
                contentDescription = films.title,
                contentScale = ContentScale.Fit
            )
            Box(modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f,

                        )
                ))
            Box(modifier = modifier
                .fillMaxHeight()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column() {
                    Text(
                        text = films.title.toString(),
                        style = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = films.releaseDate.toString(),
                        style = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp, fontStyle = FontStyle.Italic)
                    )
                }
            }
        }
    }
}