package com.example.cryptocoin.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.cryptocoin.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setListeners()
        initBanner()
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initBanner() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun setListeners() {
        buttonRateApp.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=${applicationContext.packageName}")))
        }
    }
}