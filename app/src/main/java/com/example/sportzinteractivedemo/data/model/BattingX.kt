package com.example.sportzinteractivedemo.data.model


import com.google.gson.annotations.SerializedName

data class BattingX(
    @SerializedName("Average")
    val average: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Strikerate")
    val strikerate: String,
    @SerializedName("Style")
    val style: String
)