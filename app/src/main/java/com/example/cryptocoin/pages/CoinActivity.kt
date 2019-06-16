package com.example.cryptocoin.pages

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.cryptocoin.CoinAppilation
import com.example.cryptocoin.R
import com.example.cryptocoin.di.AppComponent
import com.example.cryptocoin.pages.about.AboutActivity
import com.example.cryptocoin.pages.currency.CurrenciesListFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

class CoinActivity : AppCompatActivity() {

    val appComponent: AppComponent = CoinAppilation.instance.getComponent()
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            initFragment()
        }
        initBanner()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showAd()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        CoinAppilation.instance.releaseComponent()
    }

    private fun initBanner() {
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-7134511154282818/8240403519"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }

    private fun showAd() {
        if(mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
        }
    }

    private fun initFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, CurrenciesListFragment(), null)
            .commit()
    }
}
