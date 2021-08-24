package com.magenta.picsumtask.utils.modules

import com.magenta.picsumtask.data.api.PicsumService
import com.magenta.picsumtask.data.repository.RandomPicturesRepositoryImpl
import com.magenta.picsumtask.domain.repositories.RandomPicturesRepository
import com.magenta.picsumtask.domain.usecases.RandomPicturesUseCase
import dagger.Module
import dagger.Provides

@Module
class PicturesModule {

    @Provides
    fun provideRandomPicturesUseCase(randomPicturesRepository: RandomPicturesRepository): RandomPicturesUseCase {
        return RandomPicturesUseCase(randomPicturesRepository)
    }

    @Provides
    fun provideRandomPicturesRepository(picsumService: PicsumService): RandomPicturesRepository {
        return RandomPicturesRepositoryImpl(picsumService)
    }
}