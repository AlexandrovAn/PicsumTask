package com.magenta.picsumtask.data.repository

import com.magenta.picsumtask.data.api.PicsumService
import com.magenta.picsumtask.data.db.FavouritePicturesDao
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import com.magenta.picsumtask.domain.utils.PAGE_SIZE
import kotlinx.coroutines.delay
import javax.inject.Inject

class RandomPicturesRepositoryImpl @Inject constructor(
    private val picsumService: PicsumService,
    private val dao: FavouritePicturesDao
) : RandomPicturesRepository {

    override suspend fun getPictures(page: Int): List<Picture> {
        val networkPicturesList = picsumService.getRandomPictures(page, PAGE_SIZE)
        return PictureMapper.convertToPictureList(
            networkPicturesList,
            dao.getMatch(networkPicturesList.map { it.id })
        )
    }

}