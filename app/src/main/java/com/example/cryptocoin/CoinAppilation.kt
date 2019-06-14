package com.example.cryptocoin

import android.app.Application
import com.example.cryptocoin.di.AppComponent
import com.example.cryptocoin.di.AppModule
import com.example.cryptocoin.di.DaggerAppComponent
import com.example.cryptocoin.utils.Uri

class CoinAppilation : Application() {

    lateinit var component: AppComponent

    companion object {
        lateinit var instance: CoinAppilation private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder()
            .appModule(AppModule(Uri.BASE))
            .build()
    }
}