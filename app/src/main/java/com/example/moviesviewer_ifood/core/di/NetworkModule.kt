package com.example.moviesviewer_ifood.core.di

import com.example.moviesviewer_ifood.core.config.ApiKeyProvider
import com.example.moviesviewer_ifood.core.config.NetworkConfig
import com.example.moviesviewer_ifood.data.network.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

private val json = Json { ignoreUnknownKeys = true }

val networkModule = module {
    single { ApiKeyProvider() }

    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(NetworkConfig.BASE_URL)
            .client(get())
            .addConverterFactory(
                json.asConverterFactory(
                "application/json; charset=UTF8".toMediaType()))
            .build()
            .create(ApiService::class.java)
    }
}