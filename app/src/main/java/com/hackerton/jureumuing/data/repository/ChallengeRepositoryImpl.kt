package com.hackerton.jureumuing.data.repository

import com.hackerton.jureumuing.data.datasource.challenge.ChallengeDataSource
import com.hackerton.jureumuing.domain.model.Challenge
import com.hackerton.jureumuing.domain.repository.ChallengeRepository
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
    private val challengeDataSource: ChallengeDataSource
) : ChallengeRepository {

    override suspend fun getChallengeList(): Result<List<Challenge>> =
        kotlin.runCatching { challengeDataSource.getChallengeList().map { it.toChallenge() } }
}