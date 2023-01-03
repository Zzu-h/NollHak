package com.hackerton.jureumuing.ui.main.challenge.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hackerton.jureumuing.databinding.ItemMissionBinding
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.main.challenge.list.viewholder.MissionViewHolder

class MissionRVAdapter(
    private val onClickListener: ClickListener
) :
    ListAdapter<Mission, MissionViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        return MissionViewHolder(
            ItemMissionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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