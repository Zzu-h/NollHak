package com.hackerton.jureumuing.di

import android.content.Context
import com.hackerton.jureumuing.utils.LocalPathUtil
import com.hackerton.jureumuing.utils.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilModule {

    @Singleton
    @Provides
    fun provideSharedPreferencesManager(@ApplicationContext context: Context): SharedPreferencesManager {
        return SharedPreferencesManager(context)
    }

    @Singleton
    @Provides
    fun provideLocalPathUtil(@ApplicationContext context: Context): LocalPathUtil {
        return LocalPathUtil(context)
    }
}