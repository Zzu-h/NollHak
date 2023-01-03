package com.hackerton.jureumuing.data.datasource.mission

import com.hackerton.jureumuing.data.dto.CandidateDto
import com.hackerton.jureumuing.data.dto.MissionDto
import java.io.File

interface MissionDataSource {

    suspend fun getMissionList(): List<MissionDto>

    suspend fun getCandidateMissionList(): List<CandidateDto>

    suspend fun registerMission(
        key: String,
        image: File,
        candidateDto: CandidateDto
    )

    suspend fun admitCandidate(candidateId: Int)

    suspend fun deleteAdmitCandidate(candidateId: Int)
}