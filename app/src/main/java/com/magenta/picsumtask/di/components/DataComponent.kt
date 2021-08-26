package com.magenta.picsumtask.di.components

import com.magenta.picsumtask.di.modules.AppModule
import com.magenta.picsumtask.di.modules.DaoModule
import com.magenta.picsumtask.di.modules.NetworkModule
import com.magenta.picsumtask.di.modules.RepositoryModule
import com.magenta.picsumtask.domain.repositories.CacheRepository
import com.magenta.picsumtask.domain.repositories.FavouritePicturesRepository
import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DaoModule::class,
        RepositoryModule::class
    ]
)
interface DataComponent {

    val cacheRepository: CacheRepository
    val favouritePicturesRepository: FavouritePicturesRepository
    val randomPicturesRepository: RandomPicturesRepository
}