package com.amir.wikipedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amir.wikipedia.databinding.ItemExploreBinding
import com.amir.wikipedia.dataclasses.ItemPost
import com.bumptech.glide.Glide

class ExploreAdapter(private val data: List<ItemPost>,val itemEvent: ItemEvent) :
    RecyclerView.Adapter<ExploreAdapter.ExploreVeiwHolder>() {
    lateinit var binding: ItemExploreBinding

    inner class ExploreVeiwHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews (itemPost: ItemPost){
            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)

            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreDetail.text = itemPost.txtDetails
            binding.txtSubtitle.text = itemPost.txtSubtitle

            // send data from adapter to activity
            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreVeiwHolder {
        // handle view and save them (get the count from inner class)
        binding = ItemExploreBinding.inflate(
            LayoutInflater.from(parent.context) ,
            parent,
            false
        )
        return ExploreVeiwHolder(binding.root)
    }

    override fun getItemCount(): Int {
        // return item count to recyclerView
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreVeiwHolder, position: Int) {
        // place information into the view ( make function in the inner class)
        holder.bindViews(data[position])
    }


}