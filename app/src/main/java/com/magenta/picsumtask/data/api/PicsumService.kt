package com.magenta.picsumtask.data.api

import com.magenta.picsumtask.domain.entities.Picture
import retrofit2.http.GET
import retrofit2.http.Path

interface PicsumService {
    @GET("/v2/list?{page}&{limit}")
    suspend fun getRandomPicture(
        @Path ("page") page : Int,
        @Path ("limit") limit : Int
    ): List<Picture>
}