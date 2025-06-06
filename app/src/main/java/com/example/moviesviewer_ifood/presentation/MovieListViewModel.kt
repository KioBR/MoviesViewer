package com.example.moviesviewer_ifood.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesviewer_ifood.data.model.MovieDTO
import com.example.moviesviewer_ifood.domain.GetPopularMoviesUseCase
import com.example.moviesviewer_ifood.domain.GetTopRatedMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {


    sealed class MovieListState {
        data object Loading : MovieListState()
        data class Success(val movies: List<MovieDTO>) : MovieListState()
        data class Error(val message: String) : MovieListState()
    }

    private val _popularState = MutableStateFlow<MovieListState>(MovieListState.Loading)
    val popularState: StateFlow<MovieListState> = _popularState

    private val _topRatedState = MutableStateFlow<MovieListState>(MovieListState.Loading)
    val topRatedState: StateFlow<MovieListState> = _topRatedState

    private val _selectedMovie = MutableStateFlow<MovieDTO?>(null)
    val selectedMovie: StateFlow<MovieDTO?> = _selectedMovie

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing

    init {
        fetchAllData()
    }

    fun selectMovie(movie: MovieDTO) {
        viewModelScope.launch {
            _selectedMovie.value = movie
        }
    }

    fun refreshData() {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                fetchAllData()
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    private fun fetchPopular() {
        viewModelScope.launch {
            _popularState.value = MovieListState.Loading
            try {
                val movies = getPopularMoviesUseCase().results
                _popularState.value = MovieListState.Success(movies)
            } catch (e: Exception) {
                _popularState.value = MovieListState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    private fun fetchTopRated() {
        viewModelScope.launch {
            _topRatedState.value = MovieListState.Loading
            try {
                val movies = getTopRatedMoviesUseCase().results
                _topRatedState.value = MovieListState.Success(movies)
            } catch (e: Exception) {
                _topRatedState.value = MovieListState.Error(e.message ?: "Unknown Error")
            }
        }
    }

    fun fetchAllData() {
        fetchPopular()
        fetchTopRated()
    }
    fun clearSelectedMovie() {
        viewModelScope.launch {
            _selectedMovie.value = null
        }
    }
}