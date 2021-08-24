package com.magenta.picsumtask.utils.modules

import com.magenta.picsumtask.data.api.PicsumService
import com.magenta.picsumtask.data.repository.RandomPicturesRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .addConverterFactory(GsonConverterFactory.create())
    }
    private val picsumService: PicsumService by lazy {
        retrofitBuilder.build().create(PicsumService::class.java)
    }

    @Provides
    fun picsumService() = picsumService
}