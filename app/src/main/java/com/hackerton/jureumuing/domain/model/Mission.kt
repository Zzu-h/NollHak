package com.hackerton.jureumuing.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Mission(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val author: String,
    val _what: String,
    val _where: String = "",
    val _when: String = "",
    val challengeList: @RawValue List<Challenge> = emptyList(),
) : Parcelable