package com.hamza.iti_lab6.adapters;

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hamza.iti_lab6.databinding.PostItemBinding
import com.hamza.iti_lab6.models.PostModel
import com.hamza.iti_lab6.ui.DetailsActivity
import com.hamza.iti_lab6.utils.Const


class PostAdapter() :
    RecyclerView.Adapter<PostAdapter.Holder>() {

    var list: ArrayList<PostModel>? = null
    private val context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = PostItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list?.get(position)!!
        holder.binding.apply {
            data.apply {
                txtName.text = userName
                txtdate.text = date
                txtPost.text = post
                Glide.with(holder.itemView.context).load(data.imgUrl)
                    .apply(RequestOptions.centerCropTransform())
                    .into(imgView)
            }

            btnDetails.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
                intent.putExtra(Const.USER_NAME_KEY, data.userName)
                intent.putExtra(Const.POST_KEY, data.post)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class Holder constructor(val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}


