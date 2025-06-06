package com.example.moviesviewer_ifood.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesviewer_ifood.ui.theme.MoviesViewerIfoodTheme

@Composable
fun LoadingComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(25.dp),
            color = Color(0xFF525252),
            trackColor =Color(0xFF282828),
            strokeWidth = 4.dp
        )
    }
}

@Composable
@Preview
fun LoadingPreview() {
    MoviesViewerIfoodTheme {
        LoadingComponent()
    }
}