package com.seytkalievm.studyhub.android.di

import com.seytkalievm.studyhub.domain.api.AuthApi
import com.seytkalievm.studyhub.domain.api.StudyHubApi
import com.seytkalievm.studyhub.domain.datasource.DeckDataSource
import com.seytkalievm.studyhub.domain.datasource.hardcoded.HardcodedDeckDataSource
import com.seytkalievm.studyhub.domain.repository.AuthRepository
import com.seytkalievm.studyhub.domain.repository.StudyHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataSource(): DeckDataSource {
        return HardcodedDeckDataSource()
    }

    @Provides
    @Singleton
    fun provideStudyHubApi(): StudyHubApi {
        return StudyHubRepository()
    }

    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi {
        return AuthRepository()
    }
}