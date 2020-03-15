package com.omercankoc.catchme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
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
                TODO("Not yet implemented")
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
