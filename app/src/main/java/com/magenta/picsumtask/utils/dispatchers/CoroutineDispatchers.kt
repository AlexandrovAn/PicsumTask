package com.magenta.picsumtask.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchers {
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}