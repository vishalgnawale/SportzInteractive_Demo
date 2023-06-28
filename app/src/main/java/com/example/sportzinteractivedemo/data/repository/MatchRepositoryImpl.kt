package com.example.sportzinteractivedemo.data.repository

import android.util.Log
import com.example.sportzinteractivedemo.data.api.Resource
import com.example.sportzinteractivedemo.data.model.MatchDetails
import com.example.sportzinteractivedemo.data.repository.nzind.datasource.NzIndMatchRemoteDataSource
import com.example.sportzinteractivedemo.data.repository.sapak.datasource.SaPakRemoteDataSource
import com.example.sportzinteractivedemo.domain.repository.MatchesRepository

class MatchRepositoryImpl(
    private val nzIndMatchRemoteDataSource: NzIndMatchRemoteDataSource,
    private val saPakRemoteDataSource: SaPakRemoteDataSource
):MatchesRepository{
    override suspend fun getNzIndMatchDetails(): Resource<MatchDetails> {
        return getNzIndDataFromApi()
    }

    override suspend fun getSaPakMatchDetails(): Resource<MatchDetails> {
        return getSaPakDataFromApi()
    }

    private suspend fun getNzIndDataFromApi():Resource<MatchDetails>{
        try {
            val response=nzIndMatchRemoteDataSource.getNzIndMatchData()
            val body=response.body()
            if(body!=null&& response.isSuccessful){
                return  Resource.Success(data = body)
            }else{
                return Resource.Error(errorMessage = "Something went wrong")
            }
        }catch (e:Exception){
            Log.d("MatchData", "getNzIndDataFromApi: ${e.message.toString()}")
            return Resource.Error(errorMessage = "Something went wrong")
        }
    }
    private suspend fun getSaPakDataFromApi():Resource<MatchDetails>{
        try {
            val response=saPakRemoteDataSource.getSaPakMatchDetails()
            val body=response.body()
            if(body!=null&& response.isSuccessful){
                return  Resource.Success(data = body)
            }else{
                return Resource.Error(errorMessage = "Something went wrong")
            }
        }catch (e:Exception){
            Log.d("MatchData", "getSaPakDataFromApi: ${e.message.toString()}")
            return Resource.Error(errorMessage = "Something went wrong")
        }
    }

}