package com.magenta.picsumtask.di.components

import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.GetUseCase
import com.magenta.picsumtask.domain.usecases.LikePictureUseCase

interface FeatureProvider {
    val likeUseCase: LikePictureUseCase
    val getUseCase: GetUseCase<Picture>
}