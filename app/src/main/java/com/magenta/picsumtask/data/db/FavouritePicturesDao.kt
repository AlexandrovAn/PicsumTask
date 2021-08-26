package com.magenta.picsumtask.data.db

import androidx.room.*
import com.magenta.picsumtask.data.entities.EntityPicture

@Dao
interface FavouritePicturesDao {
    @Query("SELECT * FROM LIKED_TABLE LIMIT :pageSize OFFSET ((:page-1)*:pageSize)")
    suspend fun getAll(page: Int, pageSize: Int): List<EntityPicture>

    @Query("SELECT * FROM LIKED_TABLE WHERE id IN (:idList)")
    suspend fun getMatch(idList: List<Int>): List<EntityPicture>

    @Query("SELECT EXISTS (SELECT * FROM LIKED_TABLE WHERE id=:id) ")
    suspend fun exists(id: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPicture(picture: EntityPicture)

    @Delete
    suspend fun deletePicture(picture: EntityPicture)

}