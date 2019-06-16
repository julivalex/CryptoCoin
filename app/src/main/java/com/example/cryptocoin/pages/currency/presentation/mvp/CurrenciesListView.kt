package com.example.cryptocoin.pages.currency.presentation.mvp

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.cryptocoin.base.di.BaseView
import com.example.cryptocoin.domain.model.CoinMarkets
import com.example.cryptocoin.pages.currency.presentation.adapter.CurrenciesAdapter

interface CurrenciesListView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showData(list: CurrenciesAdapter)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun notifyAdapter()
}