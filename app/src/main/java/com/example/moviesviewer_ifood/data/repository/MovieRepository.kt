package com.example.moviesviewer_ifood.data.repository

import com.example.moviesviewer_ifood.core.config.ApiKeyProvider
import com.example.moviesviewer_ifood.data.network.ApiService

class MovieRepository(
    private val api: ApiService,
    private val apiKeyProvider: ApiKeyProvider
) {
    suspend fun getPopularMovies() = api.getPopularMovies(apiKeyProvider.getApiKey())
    suspend fun getTopRatedMovies() = api.getTopRatedMovies(apiKeyProvider.getApiKey())
    suspend fun getMovieDetails(movieId: Int) = api.getMovieDetails(movieId, apiKeyProvider.getApiKey())
}