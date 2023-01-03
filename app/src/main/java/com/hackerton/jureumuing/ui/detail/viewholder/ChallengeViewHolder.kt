package com.hackerton.jureumuing.ui.detail.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hackerton.jureumuing.databinding.ItemChallengeBinding
import com.hackerton.jureumuing.domain.model.Challenge
import com.hackerton.jureumuing.ui.detail.adapter.ChallengeRVAdapter

class ChallengeViewHolder(private val binding: ItemChallengeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Challenge, onClickListener: ChallengeRVAdapter.ClickListener) {
        binding.item = item
        binding.listener = onClickListener
    }
}