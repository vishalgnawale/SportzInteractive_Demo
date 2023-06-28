package com.example.sportzinteractivedemo.data.model


import com.google.gson.annotations.SerializedName

data class X4(
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Name_Short")
    val nameShort: String,
    @SerializedName("Players")
    val playerTeamA: PlayerTeamA
)