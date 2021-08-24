package com.magenta.picsumtask

import android.app.Application
import com.magenta.picsumtask.data.repository.PictureMapper
import com.magenta.picsumtask.utils.components.AppComponent
import com.magenta.picsumtask.utils.components.DaggerAppComponent
import com.magenta.picsumtask.utils.modules.AppModule
import com.magenta.picsumtask.utils.modules.NetworkModule
import com.magenta.picsumtask.utils.modules.PicturesModule
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class BaseApp : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .picturesModule(PicturesModule())
            .build()
        initPicasso()
        PictureMapper.context = this
    }

    private fun initPicasso() {
        Picasso.Builder(this)
            .downloader(OkHttp3Downloader(this))
            .build()
            .also { Picasso.setSingletonInstance(it) }
    }
}