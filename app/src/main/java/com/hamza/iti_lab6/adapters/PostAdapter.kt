package com.hamza.iti_lab6.adapters;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hamza.iti_lab6.databinding.PostItemBinding
import com.hamza.iti_lab6.models.PostModel


class PostAdapter() :
    RecyclerView.Adapter<PostAdapter.Holder>() {

    var list: ArrayList<PostModel>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PostItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list?.get(position )!!
        holder.binding.apply {
            data.apply {
                txtName.text= userName
                txtdate.text =date
                txtPost.text=post
                Glide.with(holder.itemView.context).load(data.imgUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .into(imgView)
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class Holder constructor(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}


