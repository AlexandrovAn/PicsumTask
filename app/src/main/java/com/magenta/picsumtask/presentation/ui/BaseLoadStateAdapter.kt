package com.magenta.picsumtask.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.magenta.picstask.databinding.LoadStateBinding

class BaseLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<BaseLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = LoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        with(holder.binding) {
            val isLoading = loadState is LoadState.Loading
            loadStateProgressBar.isVisible = isLoading
            loadStateRetryButton.isVisible = !isLoading
            loadStateErrorMessageTv.isVisible = !isLoading
            if (loadState is LoadState.Error) loadStateErrorMessageTv.text =
                loadState.error.localizedMessage
            loadStateRetryButton.setOnClickListener { retry.invoke() }
        }
    }

    class LoadStateViewHolder(val binding: LoadStateBinding) : RecyclerView.ViewHolder(binding.root)
}