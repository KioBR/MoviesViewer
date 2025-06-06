package com.example.moviesviewer_ifood.core.di

import com.example.moviesviewer_ifood.presentation.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MovieListViewModel(
            getPopularMoviesUseCase = get(),
            getTopRatedMoviesUseCase = get()
        )
    }
}
