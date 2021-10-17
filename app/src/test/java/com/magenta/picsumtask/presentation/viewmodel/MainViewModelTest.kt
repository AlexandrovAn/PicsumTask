package com.magenta.picsumtask.presentation.viewmodel


import com.magenta.picsumtask.domain.entities.Picture
import com.magenta.picsumtask.domain.usecases.GetUseCase
import com.magenta.picsumtask.domain.usecases.LikePictureUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private val getUseCase: GetUseCase<Picture> = mockk(relaxed = true)
    private val likePictureUseCase: LikePictureUseCase = mockk(relaxed = true)
    private val mainViewModel: MainViewModel by lazy {
        MainViewModel(
            getUseCase = getUseCase,
            likePictureUseCase = likePictureUseCase
        )
    }

    @Before
    fun init() {
        Dispatchers.setMain(Dispatchers.Default)
    }

    @Test
    fun `likeAction() test`() = runBlocking {
        mainViewModel.likeAction(picture = picture, onFinish = onFinish)
        coVerify {
            likePictureUseCase.likePicture(picture = picture)
            onFinish()
        }
    }

    @After
    fun clear() {
        Dispatchers.resetMain()
    }

    companion object {
        val picture = Picture(
            0,
            "Andrey",
            "https://www.freeindex.co.uk/media/listingpics/658/963/slyaeoby.png",
            true
        )
        val onFinish: () -> Unit = {}
    }
}