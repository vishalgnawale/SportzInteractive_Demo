package com.example.sportzinteractivedemo.presentation.di.core

import com.example.sportzinteractivedemo.domain.repository.MatchesRepository
import com.example.sportzinteractivedemo.domain.usecase.GetNzIndMatchDataUseCase
import com.example.sportzinteractivedemo.domain.usecase.GetSaPakMatchDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun provideNzIndUseCase(matchesRepository: MatchesRepository):GetNzIndMatchDataUseCase{
        return GetNzIndMatchDataUseCase(matchesRepository)
    }

    @Provides
    fun provideSaPakUseCase(matchesRepository: MatchesRepository):GetSaPakMatchDetailsUseCase{
        return GetSaPakMatchDetailsUseCase(matchesRepository)
    }
}