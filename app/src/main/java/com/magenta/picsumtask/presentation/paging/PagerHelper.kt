package com.magenta.picsumtask.presentation.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.utils.PAGE_SIZE

object PagerHelper {

    fun getPager(defaultSource: suspend (page: Int) -> List<Picture>): Pager<Int, Picture> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = true, maxSize = 100)
        ) { PicturesSource(defaultSource) }
    }

    private fun baseRefreshKey(state: PagingState<Int, Picture>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    private suspend fun baseLoad(
        params: PagingSource.LoadParams<Int>,
        getData: suspend (page: Int) -> List<Picture>
    ): PagingSource.LoadResult<Int, Picture> {
        val page: Int = params.key ?: 1
        val pageSize: Int = PAGE_SIZE
        return try {
            val dataset = getData(page)
            val nextKey = if (dataset.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            PagingSource.LoadResult.Page(dataset, prevKey, nextKey)
        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }

    class PicturesSource(private val getData: suspend (page: Int) -> List<Picture>) :
        PagingSource<Int, Picture>() {
        override fun getRefreshKey(state: PagingState<Int, Picture>) = baseRefreshKey(state)

        override suspend fun load(params: LoadParams<Int>) = baseLoad(params, getData)
    }

}