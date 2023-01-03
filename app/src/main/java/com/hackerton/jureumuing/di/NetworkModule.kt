package com.hackerton.jureumuing.di

import com.hackerton.jureumuing.BuildConfig
import com.hackerton.jureumuing.BuildConfig.BASE_URL
import com.hackerton.jureumuing.config.AuthorizationTokenInterceptor
import com.hackerton.jureumuing.data.service.AuthService
import com.hackerton.jureumuing.data.service.ChallengeService
import com.hackerton.jureumuing.data.service.MissionService
import com.hackerton.jureumuing.utils.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideAuthorizationTokenInterceptor(sharedPreferencesManager: SharedPreferencesManager): AuthorizationTokenInterceptor =
        AuthorizationTokenInterceptor(sharedPreferencesManager)

    @Singleton
    @Provides
    fun provideRetrofit(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authorizationTokenInterceptor: AuthorizationTokenInterceptor,
    ): Retrofit {
        val client = OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(authorizationTokenInterceptor)
            .build()
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideMissionService(retrofit: Retrofit): MissionService {
        return retrofit.create(MissionService::class.java)
    }

    @Singleton
    @Provides
    fun provideChallengeService(retrofit: Retrofit): ChallengeService {
        return retrofit.create(ChallengeService::class.java)
    }
}