package com.example.moviesviewer_ifood.core.di

import com.example.moviesviewer_ifood.domain.GetPopularMoviesUseCase
import com.example.moviesviewer_ifood.domain.GetTopRatedMoviesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetPopularMoviesUseCase(get()) }
    single { GetTopRatedMoviesUseCase(get()) }
}