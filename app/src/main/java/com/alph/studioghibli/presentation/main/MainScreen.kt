package com.alph.studioghibli.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alph.studioghibli.presentation.main.MainViewModel
import com.alph.studioghibli.presentation.ui.theme.StudioGhibliTheme
import com.alph.studioghibli.provider.shouldUseDarkMode
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBar
import com.commandiron.bubble_navigation_bar_compose.BubbleNavigationBarItem

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()

    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    when (navBackStackEntry?.destination?.route) {
        Screens.FilmDetailScreen.route + "/{filmId}" -> bottomBarState.value = false
        else -> bottomBarState.value = true
    }

    StudioGhibliTheme(darkTheme = isDarkMode) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                backgroundColor = MaterialTheme.colorScheme.background,
                bottomBar = {
                    BottomBar(navController = navController, state = bottomBarState)
                },
            )
            {
                NavigationGraph(navController = navController)
            }
        }
    }

}

@Composable
fun BottomBar(
    navController: NavHostController,
    state: MutableState<Boolean>
) {
    val screens = listOf(
        Screens.FilmListScreen,
        Screens.FilmFavoriteScreen,
        Screens.SettingsScreen
    )
    AnimatedVisibility(
        visible = state.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        BubbleNavigationBar() {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->
                BubbleNavigationBarItem(
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = screen.icon!!,
                    title = screen.title.toString(),
                    selectedColor = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}