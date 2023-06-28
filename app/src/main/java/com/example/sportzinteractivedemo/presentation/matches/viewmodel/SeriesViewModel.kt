package com.example.sportzinteractivedemo.presentation.matches.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sportzinteractivedemo.data.model.MatchDetails
import com.example.sportzinteractivedemo.data.model.Teams
import com.example.sportzinteractivedemo.domain.usecase.GetNzIndMatchDataUseCase
import com.example.sportzinteractivedemo.domain.usecase.GetSaPakMatchDetailsUseCase

class SeriesViewModel(
    private val getNzIndMatchDataUseCase: GetNzIndMatchDataUseCase,
    private val getSaPakMatchDetailsUseCase: GetSaPakMatchDetailsUseCase
):ViewModel() {

      var team1 =MutableLiveData<String>()
     var team2 = MutableLiveData<String>()
     var venueDetails=MutableLiveData<String>()
     var dateAndTime=MutableLiveData<String>()

    fun getNzIndMatchData()= liveData {
        val nzIndMatchData=getNzIndMatchDataUseCase.getNzIndMatchData()
        if (nzIndMatchData != null) {
            nzIndMatchData.data?.let { setMatchDetails(it) }
            emit(nzIndMatchData.data)
        }
    }

   private fun setMatchDetails(matchDetails: MatchDetails){
       team1.value=matchDetails.teams.x5.nameFull
       team2.value=matchDetails.teams.x4.nameFull
       venueDetails.value=matchDetails.matchdetail.venue.name
       dateAndTime.value=matchDetails.matchdetail.match.date+" - "+matchDetails.matchdetail.match.time
    }


}