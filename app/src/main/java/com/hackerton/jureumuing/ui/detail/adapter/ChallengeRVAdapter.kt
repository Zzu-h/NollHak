package com.hackerton.jureumuing.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hackerton.jureumuing.databinding.ItemChallengeBinding
import com.hackerton.jureumuing.domain.model.Challenge
import com.hackerton.jureumuing.ui.detail.viewholder.ChallengeViewHolder

class ChallengeRVAdapter(
    private val onClickListener: ClickListener
) :
    ListAdapter<Challenge, ChallengeViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        return ChallengeViewHolder(
            ItemChallengeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    interface ClickListener {
        fun onItemClick(item: Challenge)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Challenge>() {
            override fun areItemsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Challenge, newItem: Challenge): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}