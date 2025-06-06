package com.example.moviesviewer_ifood.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesviewer_ifood.presentation.MovieListViewModel
import com.example.moviesviewer_ifood.presentation.components.LoadingComponent
import com.example.moviesviewer_ifood.presentation.components.MovieSection
import com.example.moviesviewer_ifood.presentation.components.ToolbarComponent


@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel,
    onClickMovie: () -> Unit
) {
    val popularState by movieListViewModel.popularState.collectAsState()
    val topRatedState by movieListViewModel.topRatedState.collectAsState()
    val isLoading = popularState is MovieListViewModel.MovieListState.Loading ||
            topRatedState is MovieListViewModel.MovieListState.Loading

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        ToolbarComponent(hasBackButton = false)
        if (isLoading) {
            LoadingComponent()
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                MovieSection(
                    title = "Popular movies",
                    state = popularState,
                    onClickMovie = { movie ->
                        movieListViewModel.selectMovie(movie)
                        onClickMovie()
                    }
                )
            }

            item {
                MovieSection(
                    title = "Top rated movies",
                    state = topRatedState,
                    onClickMovie = { movie ->
                        movieListViewModel.selectMovie(movie)
                        onClickMovie()
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MovieListPreview() {


}
