package com.magenta.picsumtask.domain.repositories

import com.magenta.picsumtask.domain.entities.Picture

interface CacheRepository {
    fun saveCache(page: Int, pictures: List<Picture>)
    suspend fun getCache(page: Int): List<Picture>?
}