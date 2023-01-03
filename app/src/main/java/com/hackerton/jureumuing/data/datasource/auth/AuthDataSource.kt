package com.hackerton.jureumuing.data.datasource.auth

import com.hackerton.jureumuing.data.dto.AuthDto
import com.hackerton.jureumuing.data.dto.LoginDto

interface AuthDataSource {
    suspend fun login(email: LoginDto): AuthDto
}