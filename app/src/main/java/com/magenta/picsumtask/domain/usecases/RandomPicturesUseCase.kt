package com.magenta.picsumtask.domain.usecases

import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.CacheRepository
import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomPicturesUseCase @Inject constructor(
    private val randomPicturesRepository: RandomPicturesRepository,
    private val cacheRepository: CacheRepository,
) : GetUseCase<Picture> {

    override suspend fun loadData(page: Int) = withContext(Dispatchers.IO) {
        cacheRepository.getCache(page)
            ?: getPicturesFromRepo(page)
    }

    private suspend fun getPicturesFromRepo(page: Int): List<Picture> {
        return randomPicturesRepository.getPictures(page).also {
            cacheRepository.saveCache(page, it)
        }
    }
}