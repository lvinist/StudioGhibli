package com.alph.studioghibli.presentation.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.alph.studioghibli.R
import com.alph.studioghibli.presentation.common.components.MovieCard
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val checkedState = remember { mutableStateOf(viewModel.isNightMode()) }
    val scaffoldState = rememberCollapsingToolbarScaffoldState()

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
                "Settings",
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
        Row(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Dark Theme")
            Switch(checked = checkedState.value, onCheckedChange = {isChecked ->
                checkedState.value = isChecked
                viewModel.saveThemeMode(isChecked)
            })
        }
    }
}