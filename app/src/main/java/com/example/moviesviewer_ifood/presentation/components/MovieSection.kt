package com.example.moviesviewer_ifood.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesviewer_ifood.data.model.MovieDTO
import com.example.moviesviewer_ifood.presentation.MovieListViewModel
import com.example.moviesviewer_ifood.ui.theme.MoviesViewerIfoodTheme

@Composable
fun MovieSection(
    title: String,
    state: MovieListViewModel.MovieListState,
    onClickMovie: (MovieDTO) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


        when (state) {
            is MovieListViewModel.MovieListState.Loading -> {

            }

            is MovieListViewModel.MovieListState.Success -> {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(state.movies) { movie ->
                        MovieView(
                            movie = movie,
                            onClick = { onClickMovie(movie) }
                        )
                    }
                }
            }

            is MovieListViewModel.MovieListState.Error -> {
                // TRATAMENTO DE ERRO
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieSectionSuccessPreview() {
    val sampleMovies = listOf(
        MovieDTO(
            id = 1,
            title = "Sample Movie",
            overview = "Sample overview",
            posterPath = "/sample.jpg",
            voteAverage = 8.5,
            releaseDate = "1994-09-23"
        )
    )

    MoviesViewerIfoodTheme {
        MovieSection(
            title = "Popular movies",
            state = MovieListViewModel.MovieListState.Success(sampleMovies),
            onClickMovie = { }
        )
    }
}