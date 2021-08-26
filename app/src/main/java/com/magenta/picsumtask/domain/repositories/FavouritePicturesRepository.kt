package com.magenta.picsumtask.domain.repositories

import com.magenta.picsumtask.domain.entities.Picture

interface FavouritePicturesRepository {

    suspend fun addPicture(picture: Picture)

    suspend fun deletePicture(picture: Picture)

    suspend fun getSavedPictures(page: Int): List<Picture>
}