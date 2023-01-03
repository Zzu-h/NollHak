package com.hackerton.jureumuing.ui.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hackerton.jureumuing.databinding.ImageItemBinding

class RVImageAdapter(private val imgList: List<String>) :
    RecyclerView.Adapter<RVImageAdapter.ViewHolder>() {

    var onItemClick: (Int, String) -> Unit = { idx, src -> }

    override fun getItemCount(): Int = imgList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ImageItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        ), viewGroup.context
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])
        holder.binding.root.setOnClickListener { onItemClick(position, imgList[position]) }
    }


    inner class ViewHolder(val binding: ImageItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            Glide.with(context).load(image).into(binding.ivContent)
        }
    }
}