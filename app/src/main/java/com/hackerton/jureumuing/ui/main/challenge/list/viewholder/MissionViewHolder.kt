package com.hackerton.jureumuing.ui.main.challenge.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hackerton.jureumuing.databinding.ItemMissionBinding
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.main.challenge.list.adapter.MissionRVAdapter

class MissionViewHolder(private val binding: ItemMissionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Mission, onClickListener: MissionRVAdapter.ClickListener) {
        binding.item = item
        binding.listener = onClickListener
    }
}