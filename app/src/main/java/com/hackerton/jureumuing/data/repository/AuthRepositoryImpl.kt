package com.hackerton.jureumuing.data.repository

import com.hackerton.jureumuing.data.datasource.auth.AuthDataSource
import com.hackerton.jureumuing.data.dto.LoginDto
import com.hackerton.jureumuing.domain.repository.AuthRepository
import com.hackerton.jureumuing.utils.SharedPreferencesManager
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val sharedPreferencesManager: SharedPreferencesManager
) : AuthRepository {

    override suspend fun login(email: String): Result<Unit> = runCatching {
        val data = authDataSource.login(LoginDto(email))
        sharedPreferencesManager.saveJwt(data.accessToken)
    }

    override suspend fun autoLogin(): Result<Unit> = runCatching {
        sharedPreferencesManager.getJwt() ?: throw Exception()
    }
}