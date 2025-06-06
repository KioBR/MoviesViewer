package com.example.moviesviewer_ifood.presentation.components

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.moviesviewer_ifood.ui.theme.MoviesViewerIfoodTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarComponent(hasBackButton: Boolean = false, onBackClick: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(
                text = "Movies List",
                style = TextStyle.Default,
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            if (hasBackButton) {
                IconButton(onClick = { onBackClick() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        colors = topAppBarColors(
            containerColor = Color(0xFF282828),
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White,
        ),
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    MoviesViewerIfoodTheme {
        ToolbarComponent(onBackClick = {})
    }
}
