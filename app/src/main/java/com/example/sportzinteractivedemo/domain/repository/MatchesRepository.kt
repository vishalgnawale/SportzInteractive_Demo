package com.example.sportzinteractivedemo.domain.repository

import com.example.sportzinteractivedemo.data.api.Resource
import com.example.sportzinteractivedemo.data.model.MatchDetails

interface MatchesRepository {
    suspend fun getNzIndMatchDetails():Resource<MatchDetails>
    suspend fun getSaPakMatchDetails():Resource<MatchDetails>
}