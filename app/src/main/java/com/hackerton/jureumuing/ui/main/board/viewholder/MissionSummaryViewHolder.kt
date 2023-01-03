package com.hackerton.jureumuing.ui.main.board.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.hackerton.jureumuing.databinding.ItemMissionSummaryBinding
import com.hackerton.jureumuing.domain.model.Challenge
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.common.visibleView
import com.hackerton.jureumuing.ui.main.board.adapter.MissionSummaryRVAdapter

class MissionSummaryViewHolder(private val binding: ItemMissionSummaryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Mission, onClickListener: MissionSummaryRVAdapter.ClickListener) {
        binding.item = item
        binding.listener = onClickListener

        initChallengeList(item.challengeList)
    }

    private fun initChallengeList(item: List<Challenge>) {
        first(item)
    }

    private fun first(item: List<Challenge>) {
        if (item.isNotEmpty()) {
            binding.llFirstItem.visibility = visibleView(true)
            binding.tvFirstItem.text = item[0].author
            second(item)
        }
    }

    private fun second(item: List<Challenge>) {
        if (item.size > 1) {
            binding.llSecondItem.visibility = visibleView(true)
            binding.tvSecondItem.text = item[1].author
            third(item)
        }
    }

    private fun third(item: List<Challenge>) {
        if (item.size > 2) {
            binding.tvThirdItem.visibility = visibleView(true)
            binding.tvThirdItem.text = item[2].author
        }
    }
}