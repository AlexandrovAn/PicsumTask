package com.magenta.picsumtask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.GetUseCase
import com.magenta.picsumtask.domain.usecases.LikePictureUseCase
import com.magenta.picsumtask.presentation.paging.PagerHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val likePictureUseCase: LikePictureUseCase,
    private val getUseCase: GetUseCase<Picture>,
) : ViewModel() {

    val pictures = PagerHelper
        .getPager(getUseCase::loadData)
        .flow

    fun likeAction(picture: Picture, onFinish: () -> Unit) {
        viewModelScope.launch {
            likePictureUseCase.likePicture(picture)
            onFinish()
        }
    }

}