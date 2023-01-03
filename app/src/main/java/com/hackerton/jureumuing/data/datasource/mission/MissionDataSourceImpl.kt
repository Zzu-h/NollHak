package com.hackerton.jureumuing.data.datasource.mission

import com.hackerton.jureumuing.data.dto.CandidateDto
import com.hackerton.jureumuing.data.dto.MissionDto
import com.hackerton.jureumuing.data.service.MissionService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

class MissionDataSourceImpl @Inject constructor(
    private val missionService: MissionService
) : MissionDataSource {

    override suspend fun getMissionList(): List<MissionDto> = missionService.getMissionList()
    override suspend fun getCandidateMissionList(): List<CandidateDto> =
        missionService.getCandidateMissionList()

    override suspend fun registerMission(
        key: String,
        image: File,
        candidateDto: CandidateDto
    ) {
        val requestBody: MutableMap<String, RequestBody> = mutableMapOf()
        requestBody["title"] = candidateDto.title.toRequestBody("text/plain".toMediaTypeOrNull())
        requestBody["how"] = "".toRequestBody("text/plain".toMediaTypeOrNull())
        requestBody["what"] = candidateDto.what.toRequestBody("text/plain".toMediaTypeOrNull())

        val type = "image/*"
        missionService.registerMission(
            MultipartBody.Part.createFormData(
                key,
                image.name,
                image.asRequestBody(type.toMediaTypeOrNull())
            ),
            requestBody
        )
    }

    override suspend fun admitCandidate(candidateId: Int) =
        missionService.admitCandidate(candidateId)

    override suspend fun deleteAdmitCandidate(candidateId: Int) =
        missionService.deleteAdmitCandidate(candidateId)
}