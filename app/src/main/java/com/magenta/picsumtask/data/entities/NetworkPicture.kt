package com.magenta.picsumtask.data.entities

import com.google.gson.annotations.SerializedName

data class NetworkPicture(
    val id: Int,
    val author: String,
    @SerializedName("download_url")
    val url: String,
)