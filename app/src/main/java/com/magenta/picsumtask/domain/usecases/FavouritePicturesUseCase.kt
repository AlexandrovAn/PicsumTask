package com.magenta.picsumtask.domain.usecases

import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.FavouritePicturesRepository
import javax.inject.Inject

class FavouritePicturesUseCase @Inject constructor(
    private val likedPicturesRepository: FavouritePicturesRepository
) : GetUseCase<Picture> {

    override suspend fun loadData(page: Int): List<Picture> {
        return likedPicturesRepository.getSavedPictures(page)
    }
}