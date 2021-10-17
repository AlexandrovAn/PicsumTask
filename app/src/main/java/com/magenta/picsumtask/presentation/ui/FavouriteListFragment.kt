package com.magenta.picsumtask.presentation.ui

import com.magenta.picsumtask.App

class FavouriteListFragment : BaseListFragment() {

    override fun getFeatureProvider(app: App) = app.favouritePicturesComponent
}