package com.example.sportzinteractivedemo.data.model


import com.google.gson.annotations.SerializedName

data class BowlingX(
    @SerializedName("Average")
    val average: String,
    @SerializedName("Economyrate")
    val economyrate: String,
    @SerializedName("Style")
    val style: String,
    @SerializedName("Wickets")
    val wickets: String
)