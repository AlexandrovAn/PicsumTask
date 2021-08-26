package com.magenta.picsumtask.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.magenta.picstask.databinding.BaseListFragmentBinding
import com.magenta.picsumtask.App
import com.magenta.picsumtask.di.components.DaggerListComponent
import com.magenta.picsumtask.di.components.FeatureProvider
import com.magenta.picsumtask.di.components.ListComponent
import com.magenta.picsumtask.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var listComponent: ListComponent

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private lateinit var binding: BaseListFragmentBinding

    protected abstract fun getFeatureProvider(app: App): FeatureProvider

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(getFeatureProvider(context.applicationContext as App))
    }

    private fun inject(featureProvider: FeatureProvider) {
        listComponent = DaggerListComponent.builder()
            .featureProvider(featureProvider)
            .build()
        listComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BaseListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pictureAdapter = ListAdapter()
        with(binding) {
            mainRecycler.adapter = pictureAdapter.withLoadStateFooter(
                footer = BaseLoadStateAdapter { pictureAdapter.retry() }
            )
            errorState.retry.setOnClickListener { pictureAdapter.retry() }
        }

        lifecycleScope.launch {
            viewModel.pictures.collectLatest { pictureAdapter.submitData(it) }
        }

        lifecycleScope.launch {
            pictureAdapter.loadStateFlow.collect { state ->
                binding.errorState.root.isVisible = state.refresh is LoadState.Error
                if (state.append is LoadState.NotLoading && state.append.endOfPaginationReached) {
                    binding.emptyState.isVisible = pictureAdapter.itemCount < 1
                }
            }
        }

        pictureAdapter.clickListener = {
            viewModel.likeAction(it) { pictureAdapter.refresh() }
        }

    }

}