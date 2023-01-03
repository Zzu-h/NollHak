package com.hackerton.jureumuing.di

import com.hackerton.jureumuing.data.datasource.auth.AuthDataSource
import com.hackerton.jureumuing.data.datasource.auth.AuthDataSourceImpl
import com.hackerton.jureumuing.data.datasource.challenge.ChallengeDataSource
import com.hackerton.jureumuing.data.datasource.challenge.ChallengeDataSourceImpl
import com.hackerton.jureumuing.data.datasource.mission.MissionDataSource
import com.hackerton.jureumuing.data.datasource.mission.MissionDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun provideAuthDataSource(
        authDataSource: AuthDataSourceImpl
    ): AuthDataSource

    @Singleton
    @Binds
    abstract fun provideMissionDataSource(
        missionDataSource: MissionDataSourceImpl
    ): MissionDataSource

    @Singleton
    @Binds
    abstract fun provideChallengeDataSource(
        challengeDataSource: ChallengeDataSourceImpl
    ): ChallengeDataSource
}