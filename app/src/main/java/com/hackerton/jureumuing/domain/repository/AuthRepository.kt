package com.hackerton.jureumuing.domain.repository

interface AuthRepository {
    suspend fun login(email: String): Result<Unit>
    suspend fun autoLogin(): Result<Unit>
}