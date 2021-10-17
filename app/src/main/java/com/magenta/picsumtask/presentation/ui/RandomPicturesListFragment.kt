package com.magenta.picsumtask.presentation.ui

import com.magenta.picsumtask.App

class RandomPicturesListFragment : BaseListFragment() {

    override fun getFeatureProvider(app: App) = app.randomPicturesComponent
}