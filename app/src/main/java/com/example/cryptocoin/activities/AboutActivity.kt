package com.example.cryptocoin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cryptocoin.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}