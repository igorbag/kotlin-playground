package com.example.tictactoy

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        val btnSelected = view as Button

        Log.d("btnClicked: ", btnSelected.id.toString())
        var cellId = 0;

        when (btnSelected.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }

        playGame(cellId, btnSelected)
    }

    var activePlayer = 1;
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1
        }

        btnSelected.isEnabled = false;

        checkWinnder()
    }


    fun checkWinnder() {
        var winer = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }


        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }


        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }

        //col 3
        if (player1.contains(3) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }

        if (winer == 1) {
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
        } else if (winer == 2) {
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
        }
    }

    fun autoPlay() {
        var emptyCells = ArrayList<Int>()

        for (cellId in 1..9) {
            emptyCells.add(cellId)
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCells.add(cellId);
            }
        }
        val r = Random()
        val randIndex = r.nextInt(
            emptyCells.size
        )

        val cellId = emptyCells[randIndex]

        var buSelected: Button?
        buSelected = when (cellId) {
            1 -> btn1
            2 -> btn2
            3 -> btn3
            4 -> btn4
            5 -> btn5
            6 -> btn6
            7 -> btn7
            8 -> btn8
            9 -> btn9
            else ->
                btn1
        }

        playGame(cellId, buSelected)

    }

}
