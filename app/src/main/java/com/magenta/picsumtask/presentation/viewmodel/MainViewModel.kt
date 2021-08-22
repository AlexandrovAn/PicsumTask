package com.magenta.picsumtask.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.magenta.picsumtask.data.repository.NetworkPicturesRepository
import com.magenta.picsumtask.domain.entities.Picture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel() : ViewModel() {
    val networkPicturesRepository = NetworkPicturesRepository()
    val randomNetworkPictures: Flow<PagingData<Picture>> = Pager(
        config = PagingConfig(pageSize = 15, enablePlaceholders = true, maxSize = 100)
    ) {networkPicturesRepository}
        .flow
        .flowOn(Dispatchers.IO)
        .cachedIn(viewModelScope)

}