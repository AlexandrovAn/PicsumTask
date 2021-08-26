package com.magenta.picsumtask.data.api

import com.magenta.picsumtask.data.entities.NetworkPicture
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumService {

    @GET("/v2/list")
    suspend fun getRandomPictures(
        @Query("page") page: Int,
        @Query("limit") pageSize: Int
    ): List<NetworkPicture>
}