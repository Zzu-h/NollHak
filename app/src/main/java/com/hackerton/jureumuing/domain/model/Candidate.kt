package com.hackerton.jureumuing.domain.model

data class Candidate(
    val id: Int,
    val thumbnail: String?,
    val title: String,
    val author: String,
    val _what: String,
    val _where: String = "",
    val _when: String = "",
    val admitCount: Int,
)
