package com.magenta.picsumtask.domain.usecases

import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomPicturesUseCase @Inject constructor(
    private val randomPicturesRepository: RandomPicturesRepository,
) {
    suspend fun loadRandomPictures(page: Int, pageSize: Int) = withContext(Dispatchers.IO) {
        randomPicturesRepository.getPictures(page, pageSize)
    }
}