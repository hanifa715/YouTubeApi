package com.example.youtubeapi.di


import com.example.youtubeapi.ui.playlistitems.PlaylistItemsViewModel
import com.example.youtubeapi.ui.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel {
        PlaylistsViewModel(get())
    }
    viewModel {
        PlaylistItemsViewModel(get())
    }
}