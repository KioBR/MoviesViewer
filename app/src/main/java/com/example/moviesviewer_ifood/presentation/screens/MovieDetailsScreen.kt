package com.example.moviesviewer_ifood.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.moviesviewer_ifood.presentation.MovieListViewModel
import com.example.moviesviewer_ifood.presentation.components.LoadingPreview
import com.example.moviesviewer_ifood.presentation.components.MovieDetailsContent
import com.example.moviesviewer_ifood.presentation.components.ToolbarComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieDetailsScreen(
    onBackClick: () -> Unit,
    movieListViewModel: MovieListViewModel = koinViewModel()
) {
    val selectedMovie by movieListViewModel.selectedMovie.collectAsState()

    DisposableEffect(Unit) {
        onDispose {
            movieListViewModel.clearSelectedMovie()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ToolbarComponent(
            hasBackButton = true,
            onBackClick = onBackClick
        )

        selectedMovie?.let { movie ->
            MovieDetailsContent(
                movie = movie
            )
        } ?: run {
            LoadingPreview()
        }
    }
}
