package com.example.figura


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashScreen: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screenflash)

        val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
            this.finish()
    }
}