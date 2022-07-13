package com.example.tennispairing

class Match {
    val player1 = Player( )
    val player2 = Player( )

    fun gameAt40All( ) = (player1.at40Points( ) && player2.at40Points( ))

    fun pointFinished( winningPlayer: Player, loosingPlayer: Player )
    {
        if( loosingPlayer.hasAdvantage( ))
        {
            winningPlayer.incrementPoint()
            loosingPlayer.looseAdvantage( )
        }
        else if( winningPlayer.wouldWinGameWithAnotherPoint( ) && !gameAt40All())
        {
            winningPlayer.winsGame()
            loosingPlayer.lossesGame()
        }
        else winningPlayer.incrementPoint()
    }

    fun player1WonPoint( ) = pointFinished(player1, player2)
    fun player2WonPoint( ) = pointFinished(player2, player1)
    fun player1Score( ) = player1.getScoreString()
    fun player2Score( ) = player2.getScoreString()
    fun weHaveAWinner( ) = (player1.wins( ) || player2.wins( ))
    fun winnerText( ): String
    {
        return when( player1.wins( )) {
            true -> "Player 1 is the winner " + player1.getGamesWon() + " games to " + player2.getGamesWon() + " games"
            else -> "Player 2 is the winner" + player2.getGamesWon() + " games to " + player1.getGamesWon() + " games"
        }
    }

    fun restart( )
    {
        player1.restart( )
        player2.restart( )
    }
}