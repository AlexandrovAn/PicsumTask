package com.magenta.picsumtask.utils.modules

import com.magenta.picsumtask.data.repository.LikedPicturesRepository
import com.magenta.picsumtask.data.repository.NetworkPicturesRepository
import com.magenta.picsumtask.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun mainViewModelFactory(
        randomPictureRepo: NetworkPicturesRepository,
        likedPicturesRepo: LikedPicturesRepository
    ) = MainViewModelFactory(randomPictureRepo, likedPicturesRepo)
}