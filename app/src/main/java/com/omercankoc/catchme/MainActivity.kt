package com.omercankoc.catchme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var score : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Geri Sayım
        // 1 dk boyunca her saniye (ms olarak verir)
        object : CountDownTimer(60000,1000){

            // Sure bittiginde gerceklesecek operasyon.
            override fun onFinish() {
                Time.text = "Time 0"

                // Alert Operasyonu
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game")
                alert.setMessage("Restart the game?")
                alert.setPositiveButton("Yes"){dialog, which ->
                    val intent = intent
                    finish() // activity tamamen sonlandirilir.
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog, which ->
                    Toast.makeText(this@MainActivity,"Your Score $score",Toast.LENGTH_LONG).show() }
                alert.show()
            }


            // Her bir birim zamanda gerceklesecek operasyon.
            override fun onTick(millisUntilFinished: Long) {
                Time.text = "Time" + millisUntilFinished/1000
            }
        }.start() // baslat.
    }

    fun IncreaseScore(view : View){
        score++
        Score.text = "$score"
    }
}
