package com.hackerton.jureumuing.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackerton.jureumuing.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    val loginFlag = MutableStateFlow<Boolean?>(null)

    fun login(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.login(email)
                .onSuccess {
                    Log.d("Tester", "login: $it")
                    loginFlag.emit(true) }
                .onFailure {
                    Log.d("Tester", "login: $it")
                    loginFlag.emit(false)
                }
        }
    }

    fun autoLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.autoLogin()
                .onSuccess { loginFlag.emit(true) }
                .onFailure { loginFlag.emit(null) }
        }
    }
}