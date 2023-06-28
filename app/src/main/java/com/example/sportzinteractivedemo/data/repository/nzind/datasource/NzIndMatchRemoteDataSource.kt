package com.example.sportzinteractivedemo.data.repository.nzind.datasource

import com.example.sportzinteractivedemo.data.model.MatchDetails
import retrofit2.Response

interface NzIndMatchRemoteDataSource {
    suspend fun getNzIndMatchData():Response<MatchDetails>
}