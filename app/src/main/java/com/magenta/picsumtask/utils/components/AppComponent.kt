package com.magenta.picsumtask.utils.components

import com.magenta.picsumtask.domain.usecases.RandomPicturesUseCase
import com.magenta.picsumtask.presentation.viewmodel.MainViewModel
import com.magenta.picsumtask.presentation.viewmodel.MainViewModelFactory
import com.magenta.picsumtask.utils.modules.AppModule
import com.magenta.picsumtask.utils.modules.NetworkModule
import com.magenta.picsumtask.utils.modules.PicturesModule
import com.magenta.picsumtask.utils.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        PicturesModule::class
    ]
)
interface AppComponent {

    fun inject(mainViewModel: MainViewModel)
    fun getMainViewModelFactory(): MainViewModelFactory
    fun getRandomPicturesUseCase(): RandomPicturesUseCase


}