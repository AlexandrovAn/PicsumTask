package com.magenta.picsumtask.data.repository

import android.util.SparseArray
import com.magenta.picsumtask.data.db.FavouritePicturesDao
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.repositories.CacheRepository
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val dao: FavouritePicturesDao
) : CacheRepository {

    private val map = SparseArray<List<Picture>>()

    override fun saveCache(page: Int, pictures: List<Picture>) {
        map.put(page, pictures)
    }

    override suspend fun getCache(page: Int): List<Picture>? {
        return map.get(page)?.let { pictures ->
            PictureMapper.likeSynchronization(
                pictures,
                dao.getMatch(pictures.map { it.id })
            )
        }
    }

}