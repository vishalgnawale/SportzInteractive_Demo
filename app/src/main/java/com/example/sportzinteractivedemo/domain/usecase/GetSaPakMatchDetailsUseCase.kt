package com.example.sportzinteractivedemo.domain.usecase

import com.example.sportzinteractivedemo.data.api.Resource
import com.example.sportzinteractivedemo.data.model.MatchDetails
import com.example.sportzinteractivedemo.domain.repository.MatchesRepository

class GetSaPakMatchDetailsUseCase(
    private val matchesRepository: MatchesRepository
) {
    suspend fun getSaPakMatchData():Resource<MatchDetails>?=matchesRepository.getSaPakMatchDetails()
}