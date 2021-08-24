package com.magenta.picsumtask.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.magenta.picsumtask.data.entities.NetworkPicture
import com.magenta.picsumtask.domain.entities.Picture
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.Continuation
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@SuppressLint("StaticFieldLeak")
object PictureMapper {

    lateinit var context: Context

    fun convertToPictureList(networkPictureList: List<NetworkPicture>) =
        networkPictureList.map { it.toDomainPicture() }

    private fun NetworkPicture.toDomainPicture() = Picture(id, author, url, false)

    private suspend fun bitmapMapper(src: String) =
        suspendCoroutineWith<Bitmap?>(Dispatchers.Main) {
            val target = object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    it.resumeWith(Result.success(resource))
                }

                override fun onLoadCleared(placeholder: Drawable?) = Unit

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    it.resumeWithException(IllegalStateException())
                }
            }
            Glide.with(context).asBitmap().load(src).into(target)
        }
}

suspend fun <T> suspendCoroutineWith(
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    block: (Continuation<T>) -> Unit
) = withContext(dispatcher) {
    suspendCoroutine<T> { block(it) }
}


