package com.example.cryptocoin.pages.chart.presentation

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.cryptocoin.base.di.BaseView

interface LatestChartView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addEntryToChart(value: Float, date: String = "")

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addEntryToChart(value: Float, date: Float)
}