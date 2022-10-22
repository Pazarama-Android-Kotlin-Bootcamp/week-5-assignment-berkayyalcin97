package com.merttoptas.retrofittutorial.ui.favPosts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.merttoptas.retrofittutorial.data.model.PostDTO
import com.merttoptas.retrofittutorial.databinding.ItemPostLayoutBinding
import com.merttoptas.retrofittutorial.ui.posts.adapter.OnPostClickListener
import com.merttoptas.retrofittutorial.ui.posts.adapter.PostsAdapter

class FavPostAdapter(private val listener: OnPostClickListener):ListAdapter<PostDTO,FavPostAdapter.FavPostViewHolder>(PostsAdapter.PostsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPostViewHolder {
        return FavPostViewHolder(
            ItemPostLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavPostViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class FavPostViewHolder(private val binding: ItemPostLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: PostDTO, listener: OnPostClickListener) {
            binding.dataHolder = post
            binding.ivPostImage.setOnClickListener {
                listener.onPostClick(post)
            }
            binding.executePendingBindings()
        }
        }
    class FavPostsDiffUtil : DiffUtil.ItemCallback<PostDTO>() {
        override fun areItemsTheSame(oldItem: PostDTO, newItem: PostDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PostDTO, newItem: PostDTO): Boolean {
            return oldItem == newItem
        }
    }

}

interface OnPostClickListener {
    fun onPostClick(post: PostDTO)
}





