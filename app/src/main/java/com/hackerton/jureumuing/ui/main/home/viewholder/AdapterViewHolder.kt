package com.hackerton.jureumuing.ui.main.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hackerton.jureumuing.databinding.ItemOverviewBinding

class AdapterViewHolder(private val binding: ItemOverviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Pair<String, Int>) {
        binding.title = item.first
        binding.count = item.second
    }
}