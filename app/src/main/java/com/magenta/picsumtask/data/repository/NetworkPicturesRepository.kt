package com.magenta.picsumtask.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.magenta.picsumtask.domain.entities.Picture

class NetworkPicturesRepository : PagingSource<Int, Picture>() {
    override fun getRefreshKey(state: PagingState<Int, Picture>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picture> {
        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize
        val testNetworkPicturesList =
            listOf(
                Picture(0, "Nick Huyuchich", "https://picsum.photos/id/0/5616/3744", false),
                Picture(1, "Booba", "https://picsum.photos/id/1/5616/3744", false),
                Picture(2, "Yahu Esos", "https://picsum.photos/id/0/5616/3744", false),
                Picture(3, "Zh hz", "https://picsum.photos/id/1/5616/3744", false),
                Picture(4, "NH HN", "https://picsum.photos/id/0/5616/3744", false),
                Picture(5, "LK KL", "https://picsum.photos/id/0/5616/3744", false),
                Picture(6, "PL LP", "https://picsum.photos/id/1/5616/3744", false)
            )
        val nextKey = if (testNetworkPicturesList.size < pageSize) null else page + 1
        val prevKey = if (page == 1) null else page - 1
        return LoadResult.Page(testNetworkPicturesList, prevKey, nextKey)
    }
}