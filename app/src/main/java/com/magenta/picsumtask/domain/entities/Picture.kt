package com.magenta.picsumtask.domain.entities

data class Picture(
    val id: Int,
    val author: String,
    val url: String,
    val isLiked: Boolean
)