package com.magenta.picsumtask.di.modules

import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.FavouritePicturesUseCase
import com.magenta.picsumtask.domain.usecases.GetUseCase
import dagger.Binds
import dagger.Module

@Module
interface FavouritePicturesModule {

    @Binds
    fun bindFavouritePicturesListUseCase(
        favouritePicturesListUseCase: FavouritePicturesUseCase
    ): GetUseCase<Picture>
}