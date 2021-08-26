package com.magenta.picsumtask.domain.usecases

interface GetUseCase<T> {
    suspend fun loadData(page: Int): List<T>
}