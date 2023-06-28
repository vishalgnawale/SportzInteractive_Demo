package com.example.sportzinteractivedemo.presentation.di.core

import  com.example.sportzinteractivedemo.BuildConfig
import com.example.sportzinteractivedemo.data.api.MatchDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
    @Provides
    @Singleton
    fun provideMatchDataService(retrofit: Retrofit):MatchDataService{
        return retrofit.create(MatchDataService::class.java)
    }
}