package com.example.tennispairing

import android.os.Parcel
import android.os.Parcelable
import android.util.Log

class Player() : Parcelable{

    var pointsWon: Int = 0
    var gamesWon: Int = 0;

    constructor(parcel: Parcel) : this() {
        pointsWon = parcel.readInt()
        gamesWon = parcel.readInt()
    }

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(pointsWon)
        parcel.writeInt(gamesWon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}