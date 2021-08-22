package com.magenta.picsumtask.presentation.ui

import androidx.fragment.app.activityViewModels
import androidx.paging.PagingData
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.presentation.viewmodel.MainViewModel
import com.magenta.picsumtask.BaseApp
import kotlinx.coroutines.flow.Flow

class RandomPicturesListFragment : BaseListFragment() {

    private val viewModel: MainViewModel by activityViewModels() {
        (requireActivity().application as BaseApp).component.getMainViewModelFactory()
    }

    override val picturesFlow: Flow<PagingData<Picture>>
        get() = viewModel.randomNetworkPictures

}