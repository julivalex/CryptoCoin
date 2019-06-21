package com.example.cryptocoin.domain.repository

import com.example.cryptocoin.domain.model.CoinMarkets
import io.reactivex.Single

interface CoinGeckoRepository {

    /**
     * Метод получения списка криптовалют
     */
    fun getCoinMarket(vsCurrency: String): Single<List<CoinMarkets>>
}