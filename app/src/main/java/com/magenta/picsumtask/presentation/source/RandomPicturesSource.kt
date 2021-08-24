package com.magenta.picsumtask.presentation.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.RandomPicturesUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomPicturesSource @Inject constructor(
    private val randomPicturesUseCase: RandomPicturesUseCase
) : PagingSource<Int, Picture>() {
    override fun getRefreshKey(state: PagingState<Int, Picture>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picture> {
        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize
        val dataset = randomPicturesUseCase.loadRandomPictures(page, pageSize)
        val nextKey = if (dataset.size < pageSize) null else page + 1
        val prevKey = if (page == 1) null else page - 1
        return LoadResult.Page(dataset, prevKey, nextKey)
    }
}