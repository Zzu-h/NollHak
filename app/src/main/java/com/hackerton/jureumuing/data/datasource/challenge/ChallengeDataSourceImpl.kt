package com.hackerton.jureumuing.data.datasource.challenge

import com.hackerton.jureumuing.data.dto.ChallengeDto
import com.hackerton.jureumuing.data.service.ChallengeService
import javax.inject.Inject

class ChallengeDataSourceImpl @Inject constructor(
    private val challengeService: ChallengeService
) : ChallengeDataSource {

    override suspend fun getChallengeList(): List<ChallengeDto> =
        challengeService.getChallengeList()

    override suspend fun uploadChallenge(challengeDto: ChallengeDto) =
        challengeService.uploadChallenge(challengeDto)

    override suspend fun updateChallengeLike(challengePostingId: Int) =
        challengeService.updateChallengeLike(challengePostingId)
}