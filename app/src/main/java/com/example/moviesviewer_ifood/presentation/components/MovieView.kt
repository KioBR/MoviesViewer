package com.example.moviesviewer_ifood.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviesviewer_ifood.data.model.MovieDTO

@Composable
fun MovieView(
    movie: MovieDTO,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w342${movie.posterPath}",
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = movie.title,
                style = MaterialTheme.typography.labelSmall,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
    }
}
