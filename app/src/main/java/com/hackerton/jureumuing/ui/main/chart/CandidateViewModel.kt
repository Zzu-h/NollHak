package com.hackerton.jureumuing.ui.main.chart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.domain.repository.MissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CandidateViewModel @Inject constructor(
    private val missionRepository: MissionRepository
) : ViewModel() {

    private var _missionListAll = emptyList<Candidate>()
    private val _showMissionList = MutableStateFlow<List<Candidate>>(emptyList())
    val showMissionList: StateFlow<List<Candidate>> = _showMissionList

    init {
        viewModelScope.launch {
            with(missionRepository) {
                getCandidateMissionList().onSuccess {
                    _missionListAll = it
                    _showMissionList.emit(it)
                }
                    .onFailure { Log.e("Tester", "error: $it", ) }
            }
        }
    }
}