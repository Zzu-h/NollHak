package com.hackerton.jureumuing.data.service

import com.hackerton.jureumuing.data.dto.ChallengeDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ChallengeService {

    @GET("api/challenge-posting")
    suspend fun getChallengeList(): List<ChallengeDto>

    @POST("api/challenge-posting")
    suspend fun uploadChallenge(challengeDto: ChallengeDto)

    @POST("api/challenge-posting")
    suspend fun updateChallengeLike(@Query("challengePostingId") challengePostingId: Int)
}