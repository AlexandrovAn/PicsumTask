package com.magenta.picsumtask.domain.entities

import android.graphics.Bitmap

data class Picture(
    val id: Int,
    val author: String,
    val url:String,
    val isLiked: Boolean
)