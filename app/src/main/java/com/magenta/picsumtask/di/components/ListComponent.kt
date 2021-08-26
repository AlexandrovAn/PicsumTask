package com.magenta.picsumtask.di.components

import com.magenta.picsumtask.di.FragmentScope
import com.magenta.picsumtask.di.modules.ViewModelModule
import com.magenta.picsumtask.presentation.ui.BaseListFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [ViewModelModule::class],
    dependencies = [
        FeatureProvider::class
    ]
)
interface ListComponent {

    fun inject(baseListFragment: BaseListFragment)
}

