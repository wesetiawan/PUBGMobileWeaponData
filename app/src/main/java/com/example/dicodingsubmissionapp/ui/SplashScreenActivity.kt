package com.example.dicodingsubmissionapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.dicodingsubmissionapp.R

class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val SPLASH_TIME_OUT = 1000


        Handler().postDelayed({
            val home = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(home)
            finish()
        },SPLASH_TIME_OUT.toLong())
    }
}
