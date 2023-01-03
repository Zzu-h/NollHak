package com.hackerton.jureumuing.ui.main.chart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hackerton.jureumuing.databinding.ItemMissionCandidateBinding
import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.ui.main.chart.viewholder.MissionCandidateViewHolder

class MissionCandidateRVAdapter(
    private val onClickListener: ClickListener
) :
    ListAdapter<Candidate, MissionCandidateViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: MissionCandidateViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionCandidateViewHolder {
        return MissionCandidateViewHolder(
            ItemMissionCandidateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    interface ClickListener {
        fun onItemClick(item: Candidate)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Candidate>() {
            override fun areItemsTheSame(oldItem: Candidate, newItem: Candidate): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Candidate, newItem: Candidate): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}