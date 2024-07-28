package com.amir.wikipedia.adapters

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amir.wikipedia.databinding.ItemTrendBinding
import com.amir.wikipedia.dataclasses.ItemPost
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data: List<ItemPost>, val itemEvent: ItemEvent) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindViews(itemPost: ItemPost) {
            Glide
                .with(binding.root)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(24, 8))
                .into(binding.imgTrendMain)

            binding.txtTrendTitle.text = itemPost.txtTitle
            binding.txtSubtitle.text = itemPost.txtSubtitle
            binding.txtTrendInsight.text = itemPost.inSight
            binding.txtTrendNumber.text = (adapterPosition + 1).toString()

            // send data from adapter to activity
            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        // handle view and save them (get the count from inner class)
        binding = ItemTrendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrendViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        // return item count to recyclerView
        return data.size
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        // place information into the view ( make function in the inner class)
        holder.bindViews(data[position])
    }
}