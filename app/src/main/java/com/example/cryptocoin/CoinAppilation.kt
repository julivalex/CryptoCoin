package com.example.cryptocoin

import android.app.Application
import com.example.cryptocoin.di.AppComponent
import com.example.cryptocoin.di.AppModule
import com.example.cryptocoin.di.DaggerAppComponent
import com.example.cryptocoin.core.utils.Uri

class CoinAppilation : Application() {

    private var component: AppComponent? = null

    companion object {
        lateinit var instance: CoinAppilation private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        createComponent()
    }

    fun getComponent(): AppComponent {
        return component ?: createComponent()
    }

    fun releaseComponent() {
        component = null
    }

    private fun createComponent(): AppComponent {
        val component: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(Uri.BASE))
            .build()
        this.component = component
        return component
    }
}