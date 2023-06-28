package com.example.sportzinteractivedemo.data.repository.sapak.datasourceimpl

import com.example.sportzinteractivedemo.data.api.MatchDataService
import com.example.sportzinteractivedemo.data.model.MatchDetails
import com.example.sportzinteractivedemo.data.repository.sapak.datasource.SaPakRemoteDataSource
import retrofit2.Response

class SaPakRemoteDataSourceImpl(private val matchDataService: MatchDataService) :SaPakRemoteDataSource{
    override suspend fun getSaPakMatchDetails(): Response<MatchDetails> {
        return matchDataService.getSaPakMatchDetails()
    }
}