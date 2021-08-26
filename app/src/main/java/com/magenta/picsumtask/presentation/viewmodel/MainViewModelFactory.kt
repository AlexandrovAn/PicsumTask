package com.magenta.picsumtask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.GetUseCase
import com.magenta.picsumtask.domain.usecases.LikePictureUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val likedPictureUseCase: LikePictureUseCase,
    private val getUseCase: GetUseCase<Picture>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            likedPictureUseCase,
            getUseCase
        ) as T
    }
}