package com.magenta.picsumtask.presentation.ui

import androidx.paging.PagingData
import com.magenta.picsumtask.domain.entities.Picture
import kotlinx.coroutines.flow.Flow

class LikedListFragment: BaseListFragment() {
    override val picturesFlow: Flow<PagingData<Picture>>
        get() = TODO("Not yet implemented")
}