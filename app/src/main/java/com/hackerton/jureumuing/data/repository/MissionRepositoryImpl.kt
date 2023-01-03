package com.hackerton.jureumuing.data.repository

import com.hackerton.jureumuing.data.datasource.mission.MissionDataSource
import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.domain.repository.MissionRepository
import javax.inject.Inject

class MissionRepositoryImpl @Inject constructor(
    private val missionDataSource: MissionDataSource
) : MissionRepository {

    private val dumpList = listOf(
        "https://img.freepik.com/free-vector/blue-technology-digital-banner-design_1017-32257.jpg?w=2000",
        "https://cdn.pixabay.com/photo/2015/10/29/14/38/web-1012467__340.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT94eF8n0RNHFzs2frZzUZDBSDZDBbX2I3bmQ&usqp=CAU"
    )

    override suspend fun getMissionList(): Result<List<Mission>> = runCatching {
        listOf(
            Mission(0, dumpList.random(), "미션하자~~~", "누군가 했음", "인경호 다이빙하기"),
            Mission(1, dumpList.random(), "미션하자2~~~", "누군가2", "인경호 2번 다이빙하기"),
            Mission(2, dumpList.random(), "미션하자3~~~", "누군가3", "인경호 3번 다이빙하기"),
            Mission(3, dumpList.random(), "미션하자4~~~", "누군가4", "인경호 4번 다이빙하기"),
            Mission(4, dumpList.random(), "미션하자5~~~", "누군가5", "인경호 5번 다이빙하기"),
        )
    }

    override suspend fun getCandidateMissionList(): Result<List<Candidate>> =
        runCatching { missionDataSource.getCandidateMissionList().map { it.toCandidate() } }

    override suspend fun registerMission(candidate: Candidate): Result<Unit> =
        runCatching { /*missionDataSource.registerMission()*/ }
}