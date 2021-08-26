package com.magenta.picsumtask.di.modules

import com.magenta.picsumtask.domain.repositories.FavouritePicturesRepository
import com.magenta.picsumtask.domain.usecases.LikePictureUseCase
import dagger.Module
import dagger.Provides

@Module
class LikeModule {

    @Provides
    fun provideLikePictureUseCase(favouritePicturesRepository: FavouritePicturesRepository): LikePictureUseCase {
        return LikePictureUseCase(favouritePicturesRepository)
    }
}