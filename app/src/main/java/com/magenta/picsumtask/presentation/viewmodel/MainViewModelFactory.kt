package com.magenta.picsumtask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.magenta.picsumtask.presentation.source.LikedPicturesSource
import com.magenta.picsumtask.presentation.source.RandomPicturesSource
import javax.inject.Singleton

@Singleton
class MainViewModelFactory(
    private val networkPicturesRepository: RandomPicturesSource,
    private val likedPicturesRepository: LikedPicturesSource
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress
        return MainViewModel(networkPicturesRepository,likedPicturesRepository) as T
    }
}