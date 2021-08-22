package com.magenta.picsumtask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.magenta.picsumtask.data.repository.LikedPicturesRepository
import com.magenta.picsumtask.data.repository.NetworkPicturesRepository
import javax.inject.Singleton

@Singleton
class MainViewModelFactory(
    private val networkPicturesRepository: NetworkPicturesRepository,
    private val likedPicturesRepository: LikedPicturesRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress
        return MainViewModel(networkPicturesRepository,likedPicturesRepository) as T
    }
}