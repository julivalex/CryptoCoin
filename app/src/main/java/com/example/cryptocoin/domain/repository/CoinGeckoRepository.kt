package com.example.cryptocoin.domain.repository

import com.example.cryptocoin.data.bean.response.CoinMarketsResponse
import io.reactivex.Single

interface CoinGeckoRepository {

    /**
     * Метод получения списка криптовалют
     */
    fun getCoinMarket(): Single<CoinMarketsResponse>
}