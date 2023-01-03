package com.hackerton.jureumuing.data.dto


import com.google.gson.annotations.SerializedName
import com.hackerton.jureumuing.domain.model.Challenge

data class ChallengeDto(
    @SerializedName("challengeId")
    val challengeId: Int,
    @SerializedName("challengePostingId")
    val challengePostingId: Int,
    @SerializedName("challengeTitle")
    val challengeTitle: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("provingImage")
    val provingImage: String?,
    @SerializedName("provingVideo")
    val provingVideo: Any,
    @SerializedName("userId")
    val userId: Int
) {
    fun toChallenge(): Challenge = Challenge(
        id = challengeId,
        thumbnail = provingImage,
        author = nickname,
        count = 4,
        what = challengeTitle
    )
}