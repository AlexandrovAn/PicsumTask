package com.magenta.picsumtask.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.magenta.picstask.R
import com.magenta.picstask.databinding.ListItemBinding
import com.magenta.picsumtask.domain.entities.Picture

class ListAdapter :
    PagingDataAdapter<Picture, ListAdapter.PictureViewHolder>(
        diffCallback
    ) {

    var clickListener: ((Picture) -> Unit)? = null

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val item = getItem(position)
        item ?: return
        Glide.with(holder.binding.root)
            .load(item.url)
            .into(holder.binding.pictureIv)
        holder.binding.apply {
            authorTv.text = root.context.resources.getString(R.string.author_text, item.author)
            if (item.isLiked) likeButton.setImageResource(R.drawable.favorite_baseline)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        val holder = PictureViewHolder(binding)
        holder.apply {
            binding.likeButton.setOnClickListener {
                val item = getItem(absoluteAdapterPosition) ?: return@setOnClickListener
                clickListener?.invoke(item)
            }
        }
        return holder
    }

    class PictureViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Picture>() {
            override fun areItemsTheSame(oldItem: Picture, newItem: Picture) =
                areContentsTheSame(oldItem, newItem)

            override fun areContentsTheSame(oldItem: Picture, newItem: Picture) = oldItem == newItem
        }
    }
}