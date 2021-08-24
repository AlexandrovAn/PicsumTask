package com.magenta.picsumtask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.presentation.source.LikedPicturesSource
import com.magenta.picsumtask.presentation.source.RandomPicturesSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel(
    private val randomPicturesRepo: RandomPicturesSource,
    private val likedPicturesRepo: LikedPicturesSource
) : ViewModel() {

    val randomNetworkPictures: Flow<PagingData<Picture>> = Pager(
        config = PagingConfig(pageSize = 6, enablePlaceholders = true, maxSize = 100)
    ) { randomPicturesRepo }
        .flow
        .flowOn(Dispatchers.IO)
        .cachedIn(viewModelScope)

}