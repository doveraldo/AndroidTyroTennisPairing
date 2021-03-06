package com.example.tennispairing

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tennispairing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val match = Match( )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("DOVER", "onCreate")
    }

    fun updateScores( )
    {
        binding.player1Score.text = match.player1Score()
        binding.player2Score.text = match.player2Score()

        if( match.weHaveAWinner( ))
        {
            val toast = Toast.makeText(applicationContext, "We have a winner \n" + match.winnerText( ), Toast.LENGTH_LONG)
            toast.show()
            match.restart( )
        }
    }

    fun player1ButtonPressed( view: View )
    {
        match.player1WonPoint( );
        updateScores( )
    }

    fun player2ButtonPressed( view: View )
    {
        match.player2WonPoint( );
        updateScores( )
    }
}