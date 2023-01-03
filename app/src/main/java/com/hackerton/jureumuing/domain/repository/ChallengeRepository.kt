package com.hackerton.jureumuing.domain.repository

import com.hackerton.jureumuing.domain.model.Challenge

interface ChallengeRepository {
    suspend fun getChallengeList(): Result<List<Challenge>>
}