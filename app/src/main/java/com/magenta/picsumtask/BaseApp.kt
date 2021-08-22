package com.magenta.picsumtask

import android.app.Application
import com.magenta.picsumtask.utils.components.AppComponent
import com.magenta.picsumtask.utils.components.DaggerAppComponent
import com.magenta.picsumtask.utils.modules.AppModule
import com.magenta.picsumtask.utils.modules.NetworkModule

class BaseApp : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).networkModule(
            NetworkModule()
        )
            .build()

    }
}