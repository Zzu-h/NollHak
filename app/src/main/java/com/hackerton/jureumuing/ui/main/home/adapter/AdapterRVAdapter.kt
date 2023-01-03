package com.hackerton.jureumuing.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hackerton.jureumuing.databinding.ItemOverviewBinding
import com.hackerton.jureumuing.ui.main.home.viewholder.AdapterViewHolder

class AdapterRVAdapter() :
    ListAdapter<Pair<String, Int>, AdapterViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemOverviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Pair<String, Int>>() {
            override fun areItemsTheSame(
                oldItem: Pair<String, Int>,
                newItem: Pair<String, Int>
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Pair<String, Int>,
                newItem: Pair<String, Int>
            ): Boolean {
                return oldItem.first == newItem.first
            }
        }
    }
}