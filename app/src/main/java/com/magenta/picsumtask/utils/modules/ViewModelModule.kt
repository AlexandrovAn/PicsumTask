package com.magenta.picsumtask.utils.modules

import com.magenta.picsumtask.presentation.source.LikedPicturesSource
import com.magenta.picsumtask.presentation.source.RandomPicturesSource
import com.magenta.picsumtask.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun mainViewModelFactory(
        randomPictureSource: RandomPicturesSource,
        likedPicturesSource: LikedPicturesSource
    ) = MainViewModelFactory(randomPictureSource, likedPicturesSource)
}