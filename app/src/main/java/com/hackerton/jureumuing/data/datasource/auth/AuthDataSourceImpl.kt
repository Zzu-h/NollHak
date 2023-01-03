package com.hackerton.jureumuing.data.datasource.auth

import com.hackerton.jureumuing.data.dto.LoginDto
import com.hackerton.jureumuing.data.service.AuthService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun login(email: LoginDto) = authService.login(email)
}