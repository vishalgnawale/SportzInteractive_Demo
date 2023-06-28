package com.example.sportzinteractivedemo.data.repository.nzind.datasourceimpl

import com.example.sportzinteractivedemo.data.api.MatchDataService
import com.example.sportzinteractivedemo.data.model.MatchDetails
import com.example.sportzinteractivedemo.data.repository.nzind.datasource.NzIndMatchRemoteDataSource
import retrofit2.Response

class NzIndMatchRemoteDataSourceImpl(private val matchDataService: MatchDataService):
    NzIndMatchRemoteDataSource {
    override suspend fun getNzIndMatchData(): Response<MatchDetails> {
        return matchDataService.getNzIndMatchDetails()
    }
}