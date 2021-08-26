package com.magenta.picsumtask.di.components

import com.magenta.picsumtask.di.modules.FavouritePicturesModule
import com.magenta.picsumtask.di.modules.LikeModule
import com.magenta.picsumtask.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [
        LikeModule::class,
        FavouritePicturesModule::class
    ],
    dependencies = [DataComponent::class]
)
interface FavouritePicturesComponent : FeatureProvider