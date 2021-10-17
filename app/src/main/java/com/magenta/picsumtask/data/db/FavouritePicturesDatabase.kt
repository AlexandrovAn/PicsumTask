package com.magenta.picsumtask.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.magenta.picsumtask.data.entities.EntityPicture

@Database(
    entities = [EntityPicture::class],
    version = 3
)
abstract class FavouritePicturesDatabase : RoomDatabase() {

    abstract fun likedPicturesDao(): FavouritePicturesDao

    companion object {
        private const val NAME = "liked.db"

        fun buildDB(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            FavouritePicturesDatabase::class.java,
            NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}