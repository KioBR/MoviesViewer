package com.example.moviesviewer_ifood.core.config

import com.example.moviesviewer_ifood.BuildConfig

class ApiKeyProvider {
    fun getApiKey(): String = BuildConfig.TMDB_API_KEY
}