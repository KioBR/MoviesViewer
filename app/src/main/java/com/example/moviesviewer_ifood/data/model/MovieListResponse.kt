package com.example.moviesviewer_ifood.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    val results: List<MovieDTO>
)