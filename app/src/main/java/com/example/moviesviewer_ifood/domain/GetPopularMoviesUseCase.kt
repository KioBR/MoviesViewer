package com.example.moviesviewer_ifood.domain

import com.example.moviesviewer_ifood.data.repository.MovieRepository

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() = repository.getPopularMovies()
}