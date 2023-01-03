package com.hackerton.jureumuing.ui.main.chart.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hackerton.jureumuing.databinding.ItemMissionCandidateBinding
import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.main.chart.adapter.MissionCandidateRVAdapter

class MissionCandidateViewHolder(private val binding: ItemMissionCandidateBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Candidate, onClickListener: MissionCandidateRVAdapter.ClickListener) {
        binding.item = item
    }
}