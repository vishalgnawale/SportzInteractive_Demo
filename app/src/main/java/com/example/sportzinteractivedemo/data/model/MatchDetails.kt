package com.example.sportzinteractivedemo.data.model


import com.google.gson.annotations.SerializedName

data class MatchDetails(
    @SerializedName("Matchdetail")
    val matchdetail: Matchdetail,
    @SerializedName("Teams")
    val teams: Teams
)