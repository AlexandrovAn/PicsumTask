package com.magenta.picsumtask.di.modules

import android.content.Context
import com.magenta.picsumtask.data.db.FavouritePicturesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {

    @Provides
    @Singleton
    fun dao(context: Context) = FavouritePicturesDatabase.buildDB(context).likedPicturesDao()
}