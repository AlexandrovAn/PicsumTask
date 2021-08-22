package com.magenta.picsumtask.utils.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Application) {
    @Provides
    fun provideContext(): Context = context
}