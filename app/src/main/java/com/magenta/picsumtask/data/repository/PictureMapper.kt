package com.magenta.picsumtask.data.repository

import com.magenta.picsumtask.data.entities.EntityPicture
import com.magenta.picsumtask.data.entities.NetworkPicture
import com.magenta.picsumtask.domain.entities.Picture

object PictureMapper {

    fun convertToPictureList(
        networkPictureList: List<NetworkPicture>,
        dbPictureList: List<EntityPicture>
    ) = networkPictureList.map { it.toDomainPicture(dbPictureList) }

    fun likeSynchronization(
        networkPictureList: List<Picture>,
        dbPictureList: List<EntityPicture>
    ) = networkPictureList.map { it.toDomainPicture(dbPictureList) }

    private fun NetworkPicture.toDomainPicture(dbPictureList: List<EntityPicture>) =
        Picture(id, author, url, dbPictureList.find { it.id == id } != null)

    private fun Picture.toDomainPicture(dbPictureList: List<EntityPicture>) =
        Picture(id, author, url, dbPictureList.find { it.id == id } != null)
}


