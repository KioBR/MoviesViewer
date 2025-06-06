package com.example.moviesviewer_ifood.core.di

import org.koin.core.module.Module

val appModule: List<Module> = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)