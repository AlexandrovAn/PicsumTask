package com.magenta.picsumtask

import android.app.Application
import com.magenta.picsumtask.di.components.*
import com.magenta.picsumtask.di.modules.AppModule
import com.magenta.picsumtask.di.modules.DaoModule
import com.magenta.picsumtask.di.modules.LikeModule
import com.magenta.picsumtask.di.modules.NetworkModule

class App : Application() {

    private lateinit var dataComponent: DataComponent
    lateinit var randomPicturesComponent: RandomPicturesComponent
    lateinit var favouritePicturesComponent: FavouritePicturesComponent

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder()
            .appModule(AppModule(this))
            .daoModule(DaoModule())
            .networkModule(NetworkModule())
            .build()
        randomPicturesComponent = DaggerRandomPicturesComponent.builder()
            .dataComponent(dataComponent)
            .likeModule(LikeModule())
            .build()
        favouritePicturesComponent = DaggerFavouritePicturesComponent.builder()
            .dataComponent(dataComponent)
            .likeModule(LikeModule())
            .build()
    }
}