package com.hackerton.jureumuing.ui.main.board.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hackerton.jureumuing.databinding.ItemMissionSummaryBinding
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.main.board.viewholder.MissionSummaryViewHolder

class MissionSummaryRVAdapter(
    private val onClickListener: ClickListener
) :
    ListAdapter<Mission, MissionSummaryViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: MissionSummaryViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionSummaryViewHolder {
        return MissionSummaryViewHolder(
            ItemMissionSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    interface ClickListener {
        fun onItemClick(item: Mission)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Mission>() {
            override fun areItemsTheSame(oldItem: Mission, newItem: Mission): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Mission, newItem: Mission): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}