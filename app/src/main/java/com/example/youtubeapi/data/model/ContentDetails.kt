package com.example.youtubeapi.data.model


import com.google.gson.annotations.SerializedName


data class ContentDetails(
    @SerializedName("itemCount")
    val itemCount: Int
)