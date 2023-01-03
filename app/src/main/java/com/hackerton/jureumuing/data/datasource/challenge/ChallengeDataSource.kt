package com.hackerton.jureumuing.data.datasource.challenge

import com.hackerton.jureumuing.data.dto.ChallengeDto

interface ChallengeDataSource {

    suspend fun getChallengeList(): List<ChallengeDto>

    suspend fun uploadChallenge(challengeDto: ChallengeDto)

    suspend fun updateChallengeLike(challengePostingId: Int)
}