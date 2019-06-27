package com.example.cryptocoin.core.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoader(show: Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun showErrorMessage(text: String?)
}