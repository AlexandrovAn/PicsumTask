package com.magenta.picsumtask.presentation.ui

import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.flow.Flow

class RandomPicturesListFragment: BaseListFragment() {

    private val viewModel by viewModels<MainViewModel>()

    override val picturesFlow: Flow<PagingData<Picture>>
        get() = viewModel.randomNetworkPictures

}