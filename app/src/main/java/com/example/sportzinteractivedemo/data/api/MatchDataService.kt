package com.example.sportzinteractivedemo.data.api

import com.example.sportzinteractivedemo.data.model.MatchDetails
import retrofit2.Response
import retrofit2.http.GET

interface MatchDataService {
    @GET("nzin01312019187360.json")
    suspend fun getNzIndMatchDetails():Response<MatchDetails>

    @GET("sapk01222019186652.json")
    suspend fun getSaPakMatchDetails():Response<MatchDetails>
}