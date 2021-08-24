package com.magenta.picsumtask.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutineDispatchersImpl : CoroutineDispatchers {
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
}