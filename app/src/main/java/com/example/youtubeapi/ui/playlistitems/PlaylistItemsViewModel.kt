package com.example.youtubeapi.ui.playlistitems

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapi.data.model.PlaylistItemsModel
import com.example.youtubeapi.data.repository.YouTubeRepository
import com.example.youtubeapi.data.service.Resource

class PlaylistItemsViewModel(private val repository: YouTubeRepository) : ViewModel() {
    fun getPlaylistItems(
        getId: String,
        count: Int
    ): LiveData<Resource<List<PlaylistItemsModel.Item>>> = repository.getPlaylistItems(getId, count)
}