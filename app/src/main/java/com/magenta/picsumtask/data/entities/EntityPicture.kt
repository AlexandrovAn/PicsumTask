package com.magenta.picsumtask.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.magenta.picsumtask.domain.entities.Picture

@Entity(tableName = "liked_table")
data class EntityPicture(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val author: String,
    val url: String,
)

fun EntityPicture.toPicture() = Picture(id, author, url, true)
fun Picture.toEntity() = EntityPicture(id, author, url)