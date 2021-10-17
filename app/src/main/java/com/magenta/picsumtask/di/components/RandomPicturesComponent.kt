package com.magenta.picsumtask.di.components

import com.magenta.picsumtask.di.modules.LikeModule
import com.magenta.picsumtask.di.modules.RandomPictureModule
import com.magenta.picsumtask.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [
        LikeModule::class,
        RandomPictureModule::class
    ],
    dependencies = [DataComponent::class]
)
interface RandomPicturesComponent : FeatureProvider