package com.example.moviesviewer_ifood.core.di

import com.example.moviesviewer_ifood.data.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MovieRepository(get(), get()) }
}