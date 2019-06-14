package com.example.cryptocoin.di

import com.example.cryptocoin.pages.MainActivity
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}