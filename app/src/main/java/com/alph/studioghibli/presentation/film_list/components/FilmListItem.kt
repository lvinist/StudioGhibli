package com.alph.studioghibli.presentation.film_list.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alph.studioghibli.domain.dto.FilmDto

@Composable
fun FilmListItem(
    filmDto: FilmDto,
    onItemClick: (FilmDto) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(filmDto) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${filmDto.title}",
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Clip
        )
        Text(
            text = "${filmDto.releaseDate}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.align(CenterVertically)
        )
    }
}