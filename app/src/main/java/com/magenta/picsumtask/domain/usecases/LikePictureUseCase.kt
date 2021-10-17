package com.magenta.picsumtask.domain.usecases

import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.FavouritePicturesRepository
import javax.inject.Inject

class LikePictureUseCase @Inject constructor(
    private val likedPicturesRepository: FavouritePicturesRepository
) {

    suspend fun likePicture(picture: Picture) {
        when (picture.isLiked) {
            true -> {
                likedPicturesRepository.deletePicture(picture.copy(isLiked = false))
            }
            false -> {
                likedPicturesRepository.addPicture(picture.copy(isLiked = true))
            }
        }
    }
}