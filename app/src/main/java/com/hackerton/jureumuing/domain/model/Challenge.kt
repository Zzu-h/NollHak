package com.hackerton.jureumuing.domain.model

import java.io.Serializable

data class Challenge(
    val id: Int,
    val thumbnail: String?,
    val author: String,
    val count: Int,
    val what: String,
): Serializable
