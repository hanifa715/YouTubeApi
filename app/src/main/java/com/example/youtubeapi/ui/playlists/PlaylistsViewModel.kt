package com.example.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.data.model.BaseResponse
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.data.repository.YouTubeRepository
import com.example.youtubeapi.data.service.Resource

class PlaylistsViewModel(private val repository: YouTubeRepository) : ViewModel() {
    fun getPlaylists(): LiveData<Resource<List<Item>>> = repository.getPlaylists()
}