package com.example.recyclerview.viewmodels

import androidx.lifecycle.ViewModel
import com.example.recyclerview.R
import com.example.recyclerview.models.Game

class GamesViewModel: ViewModel() {
    init {

    }

    fun getGameList(): ArrayList<Game> {
        val game:Game = Game("Mario vs Sonic", 1600, "PS4","R", R.drawable.mario)
        val gameList: ArrayList<Game> = ArrayList<Game>()
        gameList.add(game)
        gameList.add(Game("Mario", 1000, "Wii", "E",R.drawable.mario))
        gameList.add(Game("Mario 2", 1000, "Wii", "E",R.drawable.mario))
        gameList.add(Game("Mario 3", 1000, "Wii", "T" ,R.drawable.mario))
        gameList.add(Game("Mario 4", 1000, "Wii","R" ,R.drawable.mario))
        gameList.add(Game("Mario 5", 1000, "Wii", "T" ,R.drawable.mario))
        gameList.add(Game("Mario 6", 1000, "Wii", "E",R.drawable.mario))
        gameList.add(Game("Mario 7", 1000, "Wii", "E",R.drawable.mario))
        gameList.add(Game("Mario 8", 1000, "Wii", "R",R.drawable.mario))
        gameList.add(Game("Mario 9", 1000, "Wii", "T",R.drawable.mario))
        gameList.add(Game("Mario 10", 1000, "Wii", "R",R.drawable.mario))
        return gameList
    }

}