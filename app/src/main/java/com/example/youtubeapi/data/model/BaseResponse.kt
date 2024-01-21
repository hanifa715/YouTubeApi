package com.example.youtubeapi.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BaseResponse(
    @SerializedName("etag")
    val etag: String,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("nextPageToken")
    val nextPageToken: String,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo
):Serializable