package com.hackerton.jureumuing.ui.main.challenge.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackerton.jureumuing.domain.model.Mission
import com.hackerton.jureumuing.domain.repository.MissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChallengeListViewModel @Inject constructor(
    private val missionRepository: MissionRepository
) : ViewModel() {

    private var _missionListAll = emptyList<Mission>()
    private val _showMissionList = MutableStateFlow<List<Mission>>(emptyList())
    val showMissionList: StateFlow<List<Mission>> = _showMissionList

    val searchKeyword = MutableStateFlow("")

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val searchFlow = searchKeyword
        .debounce(500)
        .mapLatest { query ->
            val tempList = mutableListOf<Mission>()
            _missionListAll.forEach {
                if (
                    it.title.contains(query, ignoreCase = true) ||
                    it._what.contains(query, ignoreCase = true)
                ) tempList.add(it)
            }
            _showMissionList.emit(tempList)
        }

    init {
        viewModelScope.launch {
            with(missionRepository) {
                getMissionList().onSuccess {
                    _missionListAll = it
                    _showMissionList.emit(it)
                }
            }
            searchFlow.collect()
        }
    }
}