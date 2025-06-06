package com.example.moviesviewer_ifood.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.moviesviewer_ifood.data.model.MovieDTO

@Composable
fun MovieDetailsContent(
    movie: MovieDTO,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())

    ) {
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w780${movie.posterPath}")
                    .crossfade(true)
                    .build(),
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "★",
                        color = Color.Yellow,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = String.format("%.1f", movie.voteAverage),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }


                Text(
                    text = movie.releaseDate.take(4),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }

            Text(
                text = "Overview",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = movie.overview,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f),
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
@Preview
fun MovieDetailsPreview() {
    val sampleMovie =
        MovieDTO(
            id = 1,
            title = "Sample Movie",
            overview = "Sample overview",
            posterPath = "/sample.jpg",
            voteAverage = 8.5,
            releaseDate = "1994-09-23"
        )

    MovieDetailsContent(sampleMovie)
}