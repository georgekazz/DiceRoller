package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var result_text: TextView
    var turns_counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_button = findViewById<Button>(R.id.roll_bt)


        diceImage = findViewById(R.id.dice_imageView)
        result_text = findViewById(R.id.resultTextView)

        roll_button.setOnClickListener {
            roll_button.text = "Good luck"
           turns_counter =  turns_counter!! + 1

            Toast.makeText(this,"This is the $turns_counter turn", Toast.LENGTH_LONG).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6)+1
        var result: Int = 0

        result = when (randomInt) {
            1 -> {
                result_text.text = "1"
                R.drawable.dice_1
            }
            2 -> {
                result_text.text = "2"
                R.drawable.dice_2
            }
            3 -> {
                result_text.text = "3"
                R.drawable.dice_3
            }
            4 -> {
                result_text.text = "4"
                R.drawable.dice_4
            }
            5 -> {
                result_text.text = "5"
                R.drawable.dice_5
            }
            else -> {
                result_text.text = "6"
                R.drawable.dice_6
            }
        }
        diceImage.setImageResource(result)
    }
}