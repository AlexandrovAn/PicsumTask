package com.magenta.picsumtask.di.components

import com.magenta.picsumtask.domain.usecases.LikePictureUseCase
import com.magenta.picsumtask.domain.usecases.FavouritePicturesUseCase
import com.magenta.picsumtask.domain.usecases.RandomPicturesUseCase
import com.magenta.picsumtask.di.modules.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        DaoModule::class
    ]
)
interface AppComponent {

    fun getRandomPicturesUseCase(): RandomPicturesUseCase
    fun getLikedPictureUseCase(): LikePictureUseCase
    fun getLikedPicturesUseCase(): FavouritePicturesUseCase
}