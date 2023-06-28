package com.example.sportzinteractivedemo.data.repository.sapak.datasource

import com.example.sportzinteractivedemo.data.model.MatchDetails
import retrofit2.Response

interface SaPakRemoteDataSource {
    suspend fun getSaPakMatchDetails():Response<MatchDetails>
}