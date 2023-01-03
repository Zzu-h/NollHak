package com.hackerton.jureumuing.ui.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackerton.jureumuing.domain.model.Challenge
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.domain.repository.ChallengeRepository
import com.hackerton.jureumuing.domain.repository.MissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val missionRepository: MissionRepository,
    private val challengeRepository: ChallengeRepository,
) : ViewModel() {

    private val _showMissionList = MutableStateFlow<List<Mission>>(emptyList())
    val showMissionList: StateFlow<List<Mission>> = _showMissionList
    private val _showChallengeList = MutableStateFlow<List<Challenge>>(emptyList())
    val showChallengeList: StateFlow<List<Challenge>> = _showChallengeList

    init {
        viewModelScope.launch {
            missionRepository.getMissionList().onSuccess {
                _showMissionList.emit(it)
            }.onFailure { Log.e("Tester", "error: $it") }

            challengeRepository.getChallengeList().onSuccess {
                _showChallengeList.emit(it)
            }.onFailure { Log.e("Tester", "error: $it") }
        }
    }
}