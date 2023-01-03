package com.hackerton.jureumuing.domain.repository

import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.domain.model.Mission

interface MissionRepository {
    suspend fun getMissionList(): Result<List<Mission>>

    suspend fun getCandidateMissionList(): Result<List<Candidate>>

    suspend fun registerMission(candidate: Candidate): Result<Unit>
}