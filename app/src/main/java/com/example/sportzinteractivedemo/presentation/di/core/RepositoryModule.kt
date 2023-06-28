package com.example.sportzinteractivedemo.presentation.di.core

import com.example.sportzinteractivedemo.data.repository.MatchRepositoryImpl
import com.example.sportzinteractivedemo.data.repository.nzind.datasource.NzIndMatchRemoteDataSource
import com.example.sportzinteractivedemo.data.repository.sapak.datasource.SaPakRemoteDataSource
import com.example.sportzinteractivedemo.domain.repository.MatchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMatchRepository(
        nzIndMatchRemoteDataSource: NzIndMatchRemoteDataSource,
        saPakRemoteDataSource: SaPakRemoteDataSource
    ):MatchesRepository{
        return MatchRepositoryImpl(nzIndMatchRemoteDataSource,saPakRemoteDataSource)
    }
}