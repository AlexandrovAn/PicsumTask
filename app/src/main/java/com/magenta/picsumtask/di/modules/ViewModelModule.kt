package com.magenta.picsumtask.di.modules

import androidx.lifecycle.ViewModelProvider
import com.magenta.picsumtask.presentation.viewmodel.MainViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Binds
    fun mainViewModelFactory(mainViewModelFactory: MainViewModelFactory): ViewModelProvider.Factory
}