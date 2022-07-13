package com.example.tennispairing

import android.util.Log

class Player {

    var pointsWon: Int = 0
    var gamesWon: Int = 0;

    fun restart( ) {
        pointsWon = 0
        gamesWon = 0
    }

    fun incrementPoint( )
    {
        pointsWon = when(pointsWon) {
            0 -> 15
            15 -> 30
            30 -> 40
            40 -> 50
            else -> Log.d("DOVER", "Player.incrementPoint bad value $pointsWon")
        }
    }

    fun wins( ) = gamesWon == 6
    fun at40Points( ) = (pointsWon == 40)
    fun hasAdvantage( ) = (pointsWon == 50)
    fun wouldWinGameWithAnotherPoint( ) = (pointsWon == 40 || pointsWon == 50)
    fun winsGame( ) {
        gamesWon++
        pointsWon = 0
    }

    fun lossesGame( ) {
        pointsWon = 0
    }

    fun looseAdvantage( ) {
        pointsWon = when(pointsWon) {
            50 -> 40
            else -> Log.d("DOVER", "Trying to loose advantage when we didn't have it")
        }
    }

    fun getGamesWon( ) = gamesWon.toShort()
    fun getScoreString( ): String
    {
      return "Games = $gamesWon Points = " +
        when(pointsWon) {
            0, 15, 30, 40 -> pointsWon
            else -> "Adv"
        }
    }
}