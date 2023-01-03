package com.hackerton.jureumuing.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hackerton.jureumuing.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

fun visibleView(isVisible: Boolean): Int = if (isVisible) View.VISIBLE else View.GONE

@BindingAdapter("image")
fun ImageView.setImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.img_battles_background)
            .into(this)
    }
}

@BindingAdapter("state")
fun ImageView.setState(state: Boolean) {
    this.isSelected = state
}

@BindingAdapter("layoutMargin")
fun ImageView.setLayoutMargin(dimen: Float) {
    val layoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    with(layoutParams) {
        bottomMargin = dimen.toInt()
        topMargin = dimen.toInt()
        leftMargin = dimen.toInt()
        rightMargin = dimen.toInt()
    }
    this.layoutParams = layoutParams
}


@BindingAdapter("nullableText")
fun TextView.setNullableText(string: String?) {
    string?.apply { text = this }
}

@BindingAdapter("songTime")
fun TextView.setSongTime(time: Long?) {
    text = if (time == null) "4:00"
    else {
        val s = time / 1000
        val m = s / 60

        "$m:${String.format("%02d", s % 60)}"
    }
}

@BindingAdapter("songTime")
fun SeekBar.setSongTime(time: Long?) {
    time?.let { this.progress = it.toInt() }
}

@BindingAdapter("endTime")
fun SeekBar.setMaxTime(endTime: Long) {
    this.max = endTime.toInt()
}