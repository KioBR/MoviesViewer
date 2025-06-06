package com.example.moviesviewer_ifood.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDTO(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("release_date")
    val releaseDate : String
)
