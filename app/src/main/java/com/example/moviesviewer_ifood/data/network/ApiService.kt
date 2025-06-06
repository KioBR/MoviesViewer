package com.example.moviesviewer_ifood.data.network

import com.example.moviesviewer_ifood.data.model.MovieDTO
import com.example.moviesviewer_ifood.data.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String): MovieDTO
}