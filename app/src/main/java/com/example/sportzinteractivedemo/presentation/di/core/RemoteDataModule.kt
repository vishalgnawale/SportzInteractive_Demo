package com.example.sportzinteractivedemo.presentation.di.core

import com.example.sportzinteractivedemo.data.api.MatchDataService
import com.example.sportzinteractivedemo.data.repository.nzind.datasource.NzIndMatchRemoteDataSource
import com.example.sportzinteractivedemo.data.repository.nzind.datasourceimpl.NzIndMatchRemoteDataSourceImpl
import com.example.sportzinteractivedemo.data.repository.sapak.datasource.SaPakRemoteDataSource
import com.example.sportzinteractivedemo.data.repository.sapak.datasourceimpl.SaPakRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideNzIndDataSource(matchDataService: MatchDataService):NzIndMatchRemoteDataSource{
        return NzIndMatchRemoteDataSourceImpl(matchDataService)
    }
    @Singleton
    @Provides
    fun provideSaPakDataSource(matchDataService: MatchDataService):SaPakRemoteDataSource{
        return SaPakRemoteDataSourceImpl(matchDataService)
    }

}