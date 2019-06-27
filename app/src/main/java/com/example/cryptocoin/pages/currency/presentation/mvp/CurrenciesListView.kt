package com.example.cryptocoin.pages.currency.presentation.mvp

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.cryptocoin.core.mvp.BaseView
import com.example.cryptocoin.domain.model.CoinMarkets

interface CurrenciesListView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showData(list: List<CoinMarkets>)
}