package com.magenta.picsumtask.domain.repositories

import com.magenta.picsumtask.domain.entities.Picture

interface RandomPicturesRepository  {
   suspend fun getPictures(page: Int, pageSize: Int): List<Picture>
}