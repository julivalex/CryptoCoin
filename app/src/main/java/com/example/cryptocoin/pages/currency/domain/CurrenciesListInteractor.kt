package com.example.cryptocoin.pages.currency.domain

import com.example.cryptocoin.domain.model.CoinMarkets
import com.example.cryptocoin.domain.repository.CoinGeckoRepository
import io.reactivex.Single
import javax.inject.Inject

class CurrenciesListInteractor @Inject constructor(
    private val repository: CoinGeckoRepository
) {
    fun getCoinMarket(vsCurrency: String): Single<List<CoinMarkets>> = repository.getCoinMarket(vsCurrency)
}