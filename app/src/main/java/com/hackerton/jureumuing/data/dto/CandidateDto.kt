package com.hackerton.jureumuing.data.dto


import com.google.gson.annotations.SerializedName
import com.hackerton.jureumuing.domain.model.Candidate

data class CandidateDto(
    @SerializedName("admitCount")
    val admitCount: Int,
    @SerializedName("candidateId")
    val candidateId: Int,
    @SerializedName("exampleImage")
    val exampleImage: String,
    @SerializedName("how")
    val how: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("what")
    val what: String,
    @SerializedName("when")
    val whenX: String,
    @SerializedName("where")
    val `where`: String,
    @SerializedName("writer")
    val writer: String
) {
    fun toCandidate(): Candidate = Candidate(
        id = candidateId,
        admitCount = admitCount,
        thumbnail = exampleImage,
        title = title,
        _what = what,
        _when = whenX,
        _where = where,
        author = writer
    )
}