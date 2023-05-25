package com.seytkalievm.studyhub.android.di

import android.content.Context
import com.seytkalievm.studyhub.domain.api.AuthApi
import com.seytkalievm.studyhub.domain.api.StudyHubApi
import com.seytkalievm.studyhub.domain.datasource.DeckDataSource
import com.seytkalievm.studyhub.domain.datasource.hardcoded.HardcodedDeckDataSource
import com.seytkalievm.studyhub.domain.datastore.getDataStore
import com.seytkalievm.studyhub.domain.repository.AuthRepository
import com.seytkalievm.studyhub.domain.repository.StudyHubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideStudyHubApi(@ApplicationContext context: Context): StudyHubApi {
        return StudyHubRepository(getDataStore(context))
    }

    @Provides
    @Singleton
    fun provideAuthApi(@ApplicationContext context: Context): AuthApi {
        return AuthRepository(getDataStore(context))
    }
}