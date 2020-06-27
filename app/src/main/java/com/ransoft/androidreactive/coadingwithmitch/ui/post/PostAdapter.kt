package com.ransoft.androidreactive.coadingwithmitch.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ransoft.androidreactive.R
import com.ransoft.androidreactive.coadingwithmitch.data.modal.Post
import com.ransoft.androidreactive.databinding.PostItemBinding

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    var posts: List<Post>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.post_item,
            parent,
            false
        )
    )

    override fun getItemCount() = posts?.size ?: 0

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.title.setText(posts!![position].title)
        // holder.binding.numComments.setText((posts!![position].comment?.size).toString())
    }

    inner class PostViewHolder(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}