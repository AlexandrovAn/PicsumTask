package com.magenta.picsumtask.di.modules

import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.GetUseCase
import com.magenta.picsumtask.domain.usecases.RandomPicturesUseCase
import dagger.Binds
import dagger.Module

@Module
interface RandomPictureModule {

    @Binds
    fun bindRandomPicturesUseCase(
        randomPicturesUseCase: RandomPicturesUseCase
    ): GetUseCase<Picture>
}