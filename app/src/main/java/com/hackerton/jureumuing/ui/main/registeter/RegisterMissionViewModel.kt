package com.hackerton.jureumuing.ui.main.registeter

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackerton.jureumuing.domain.model.Candidate
import com.hackerton.jureumuing.domain.repository.MissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RegisterMissionViewModel @Inject constructor(
    private val missionRepository: MissionRepository
) : ViewModel() {

    val title = MutableStateFlow("")
    val content = MutableStateFlow("")
    val location = MutableStateFlow("")

    private val _uri = MutableStateFlow<String?>(null)
    val uri: StateFlow<String?> = _uri

    fun setImage(uri: Uri) {
        viewModelScope.launch {
            _uri.emit(uri.toString())
        }
    }

    fun registerMission() {
        viewModelScope.launch {
            missionRepository.registerMission(
                Candidate(
                    -1,
                    _uri.value,
                    title.value,
                    "",
                    content.value,
                    location.value,
                    Date().toString(),
                    0
                )
            )
        }
    }
}