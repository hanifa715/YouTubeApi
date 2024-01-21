package com.example.youtubeapi.data.service

import com.example.youtubeapi.data.model.BaseResponse
import com.example.youtubeapi.data.model.PlaylistItemsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {
    @GET("playlists")
    suspend fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults: Int
    ):Response<BaseResponse>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("key") apiKey: String,
        @Query("playlistId") playlistsId: String,
        @Query("maxResults") maxResults: Int,
        @Query("part") part: String,
    ):Response<PlaylistItemsModel>
}