package com.magenta.picsumtask.data.repository

import com.magenta.picsumtask.data.api.PicsumService
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import javax.inject.Inject

class RandomPicturesRepositoryImpl @Inject constructor(
    private val picsumService: PicsumService
) : RandomPicturesRepository {

    override suspend fun getPictures(page: Int, pageSize: Int): List<Picture> {
        val networkPicturesList = picsumService.getRandomPictures(page, pageSize)
        return PictureMapper.convertToPictureList(networkPicturesList)
    }

}