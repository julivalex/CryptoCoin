package com.example.cryptocoin.di

import com.example.cryptocoin.pages.chart.di.ChartComponent
import com.example.cryptocoin.pages.currency.di.CurrenciesListComponent
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun currenciesListComponent(): CurrenciesListComponent

    fun chartComponent(): ChartComponent
}