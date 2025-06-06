package com.example.moviesviewer_ifood.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesviewer_ifood.presentation.MovieListViewModel
import com.example.moviesviewer_ifood.presentation.screens.MovieDetailsScreen
import com.example.moviesviewer_ifood.presentation.screens.MovieListScreen
import org.koin.androidx.compose.koinViewModel

object NavRoutes {
    const val MOVIE_LIST = "movieList"
    const val MOVIE_DETAILS = "movieDetail"
}

@Composable
fun MovieNav(
    navController: NavHostController = rememberNavController()
) {
    val viewModel = koinViewModel<MovieListViewModel>()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.MOVIE_LIST
    ) {

        composable(NavRoutes.MOVIE_LIST) {

            MovieListScreen(
                viewModel,
                onClickMovie = {
                    navController.navigate(NavRoutes.MOVIE_DETAILS)
                }
            )
        }

        composable(NavRoutes.MOVIE_DETAILS) {
            MovieDetailsScreen(
                onBackClick = { navController.popBackStack() },
                viewModel
            )
        }
    }
}