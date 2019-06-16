package com.example.cryptocoin.pages.chart.di

import dagger.Subcomponent

@ChartScope
@Subcomponent(modules = [ChartModule::class])
interface ChartComponent {

    //fun inject(fragment: CurrenciesListFragment)
}