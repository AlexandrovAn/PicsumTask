package com.magenta.picsumtask.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.magenta.picstask.databinding.BaseListFragmentBinding
import com.magenta.picsumtask.domain.entities.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseListFragment : Fragment() {

    private lateinit var binding: BaseListFragmentBinding
    protected abstract val picturesFlow: Flow<PagingData<Picture>>

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
            picturesFlow.collectLatest { pictureAdapter.submitData(it) }
        }

    }

}