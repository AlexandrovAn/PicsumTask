package com.magenta.picsumtask.di.modules

import com.magenta.picsumtask.data.repository.CacheRepositoryImpl
import com.magenta.picsumtask.data.repository.LikedPicturesRepositoryImpl
import com.magenta.picsumtask.data.repository.RandomPicturesRepositoryImpl
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.CacheRepository
import com.magenta.picsumtask.domain.repositories.FavouritePicturesRepository
import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import com.magenta.picsumtask.domain.usecases.GetUseCase
import com.magenta.picsumtask.domain.usecases.LikePictureUseCase
import com.magenta.picsumtask.domain.usecases.FavouritePicturesUseCase
import com.magenta.picsumtask.domain.usecases.RandomPicturesUseCase
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier

@Module
interface RepositoryModule {

    @Binds
    fun bindRandomPicturesRepository(
        randomPicturesRepositoryImpl: RandomPicturesRepositoryImpl
    ): RandomPicturesRepository

    @Binds
    fun bindLikePicturesRepository(
        likedPicturesRepositoryImpl: LikedPicturesRepositoryImpl
    ): FavouritePicturesRepository

    @Binds
    fun bindCacheRepository(
        cacheRepositoryImpl: CacheRepositoryImpl
    ): CacheRepository
}








