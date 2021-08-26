package com.magenta.picsumtask.data.repository

import com.magenta.picsumtask.data.db.FavouritePicturesDao
import com.magenta.picsumtask.data.entities.toEntity
import com.magenta.picsumtask.data.entities.toPicture
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.FavouritePicturesRepository
import com.magenta.picsumtask.domain.utils.PAGE_SIZE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LikedPicturesRepositoryImpl @Inject constructor(
    private val dao: FavouritePicturesDao
) : FavouritePicturesRepository {

    override suspend fun addPicture(picture: Picture) = withContext(Dispatchers.IO) {
        dao.insertPicture(picture.toEntity())
    }

    override suspend fun deletePicture(picture: Picture) = withContext(Dispatchers.IO) {
        dao.deletePicture(picture.toEntity())
    }

    override suspend fun getSavedPictures(page: Int) = withContext(Dispatchers.IO) {
        dao.getAll(page, PAGE_SIZE).map { it.toPicture() }
    }
}