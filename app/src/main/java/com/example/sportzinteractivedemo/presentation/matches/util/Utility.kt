package com.example.sportzinteractivedemo.presentation.matches.util

import com.example.sportzinteractivedemo.data.model.*

class Utility {

    companion object PlayerData {
         var playerListA=ArrayList<PlayerInfo>()
        var playerListB=ArrayList<PlayerInfo>()
        fun returnPlayerListA(playerTeamA: PlayerTeamA):List<PlayerInfo>{
            playerListA.clear()
            val player1=playerTeamA.x3632
            playerListA.add(player1)
            val player2=playerTeamA.x3722
            playerListA.add(player2)
            val player3=playerTeamA.x3852
            playerListA.add(player3)
            val player4=playerTeamA.x4176
            playerListA.add(player4)
            val player5=playerTeamA.x4532
            playerListA.add(player5)
            val player6=playerTeamA.x5132
            playerListA.add(player6)
            val player7=playerTeamA.x63187
            playerListA.add(player7)
            val player8=playerTeamA.x63751
            playerListA.add(player8)
            val player9=playerTeamA.x65867
            playerListA.add(player9)
            val player10=playerTeamA.x66818
            playerListA.add(player10)
            val player11=playerTeamA.x9844
            playerListA.add(player11)
            return playerListA
        }

        fun returnPlayerListB(playerTeamB: PlayerTeamB):List<PlayerInfo>{
            playerListB.clear()
            val player1=playerTeamB.x10167
            playerListB.add(player1)
            val player2=playerTeamB.x11703
            playerListB.add(player2)
            val player3=playerTeamB.x11703
            playerListB.add(player3)
            val player4=playerTeamB.x11706
            playerListB.add(player4)
            val player5=playerTeamB.x3752
            playerListB.add(player5)
            val player6=playerTeamB.x4330
            playerListB.add(player6)
            val player7=playerTeamB.x4338
            playerListB.add(player7)
            val player8=playerTeamB.x4964
            playerListB.add(player8)
            val player9=playerTeamB.x57594
            playerListB.add(player9)
            val player10=playerTeamB.x57903
            playerListB.add(player10)
            val player11=playerTeamB.x60544
            playerListB.add(player11)

            return playerListB
        }
    }
}