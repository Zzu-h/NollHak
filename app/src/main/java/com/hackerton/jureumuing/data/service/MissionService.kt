package com.hackerton.jureumuing.data.service

import com.hackerton.jureumuing.data.dto.CandidateDto
import com.hackerton.jureumuing.data.dto.MissionDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface MissionService {

    @GET("api/challenges/all")
    suspend fun getMissionList(): List<MissionDto>

    @GET("api/candidates")
    suspend fun getCandidateMissionList(): List<CandidateDto>

    @Multipart
    @POST("api/candidates")
    suspend fun registerMission(
        @Part exampleImage: MultipartBody.Part,
        @PartMap params: Map<String, @JvmSuppressWildcards RequestBody>
    )

    @POST("api/admits")
    suspend fun admitCandidate(@Query("candidateId") candidateId: Int)

    @DELETE("api/admits")
    suspend fun deleteAdmitCandidate(@Query("candidateId") candidateId: Int)
}