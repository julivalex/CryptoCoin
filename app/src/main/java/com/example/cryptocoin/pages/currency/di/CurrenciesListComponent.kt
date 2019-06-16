package com.example.cryptocoin.pages.currency.di

import com.example.cryptocoin.pages.currency.CurrenciesListFragment
import dagger.Subcomponent

@CurrenciesListScope
@Subcomponent(modules = [CurrenciesListModule::class])
interface CurrenciesListComponent {

    fun inject(fragment: CurrenciesListFragment)
}