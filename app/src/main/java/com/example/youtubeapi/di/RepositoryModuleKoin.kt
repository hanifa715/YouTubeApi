package com.example.youtubeapi.di

import com.example.youtubeapi.data.repository.YouTubeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        YouTubeRepository(get())
    }
}