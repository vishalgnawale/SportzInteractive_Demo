package com.example.sportzinteractivedemo.data.model


import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class PlayerInfo(
    @SerializedName("Batting")
    val batting: BattingX,
    @SerializedName("Bowling")
    val bowling: BowlingX,
    @SerializedName("Name_Full")
    val nameFull: String,
    @SerializedName("Position")
    val position: String,
    @Ignore
    @SerializedName("Iskeeper")
    val isKeeper:Boolean,
    @Ignore
    @SerializedName("Iscaptain")
    val isCaptain:Boolean

)