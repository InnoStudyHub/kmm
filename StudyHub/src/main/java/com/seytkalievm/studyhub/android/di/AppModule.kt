package com.seytkalievm.studyhub.android.di

import com.seytkalievm.studyhub.domain.datasource.DeckDataSource
import com.seytkalievm.studyhub.domain.datasource.hardcoded.HardcodedDeckDataSource
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
}