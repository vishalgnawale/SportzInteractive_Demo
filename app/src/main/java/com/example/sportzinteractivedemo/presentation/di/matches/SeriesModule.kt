package com.example.sportzinteractivedemo.presentation.di.matches

import com.example.sportzinteractivedemo.domain.usecase.GetNzIndMatchDataUseCase
import com.example.sportzinteractivedemo.domain.usecase.GetSaPakMatchDetailsUseCase
import com.example.sportzinteractivedemo.presentation.matches.viewmodel.SeriesViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
class SeriesModule {
    @ActivityScoped
    @Provides
    fun seriesViewModelFactory(
        getNzIndMatchDataUseCase: GetNzIndMatchDataUseCase,
        getSaPakMatchDetailsUseCase: GetSaPakMatchDetailsUseCase
    ):SeriesViewModelFactory{
        return SeriesViewModelFactory(getNzIndMatchDataUseCase,getSaPakMatchDetailsUseCase)
    }
}