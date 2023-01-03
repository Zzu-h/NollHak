package com.hackerton.jureumuing.ui.main.challenge.upload

import android.net.Uri
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
class ChallengeUploadViewModel @Inject constructor(
    private val missionRepository: MissionRepository
) : ViewModel() {

    var mission: Mission? = null

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
}