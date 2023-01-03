package com.hackerton.jureumuing.data.service

import com.hackerton.jureumuing.data.dto.AuthDto
import com.hackerton.jureumuing.data.dto.LoginDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/users")
    suspend fun login(@Body loginDto: LoginDto): AuthDto
}