package com.hackerton.jureumuing.ui.main.board

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.domain.repository.MissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val missionRepository: MissionRepository
) : ViewModel() {

    private var _missionListAll = emptyList<Mission>()
    private val _showMissionList = MutableStateFlow<List<Mission>>(emptyList())
    val showMissionList: StateFlow<List<Mission>> = _showMissionList

    init {
        viewModelScope.launch {
            with(missionRepository) {
                getMissionList().onSuccess {
                    _missionListAll = it
                    _showMissionList.emit(it)
                }
            }
        }
    }
}