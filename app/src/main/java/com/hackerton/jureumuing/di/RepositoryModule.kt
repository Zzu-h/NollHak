package com.hackerton.jureumuing.di

import com.hackerton.jureumuing.data.repository.AuthRepositoryImpl
import com.hackerton.jureumuing.data.repository.ChallengeRepositoryImpl
import com.hackerton.jureumuing.data.repository.MissionRepositoryImpl
import com.hackerton.jureumuing.domain.repository.AuthRepository
import com.hackerton.jureumuing.domain.repository.ChallengeRepository
import com.hackerton.jureumuing.domain.repository.MissionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideMissionRepository(
        missionRepository: MissionRepositoryImpl
    ): MissionRepository

    @Singleton
    @Binds
    abstract fun provideChallengeRepository(
        challengeRepository: ChallengeRepositoryImpl
    ): ChallengeRepository

    @Singleton
    @Binds
    abstract fun provideAuthRepository(
        authRepository: AuthRepositoryImpl
    ): AuthRepository
}