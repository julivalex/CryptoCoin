package com.example.cryptocoin.data.repository

import com.example.cryptocoin.core.converter.ConverterFactory
import com.example.cryptocoin.data.bean.response.CoinMarketsResponse
import com.example.cryptocoin.data.repository.api.CoinGeckoApi
import com.example.cryptocoin.domain.model.CoinMarkets
import com.example.cryptocoin.domain.repository.CoinGeckoRepository
import io.reactivex.Single

class CoinGeckoRepositoryImpl(
    private val coinGeckoApi: CoinGeckoApi,
    private val convertFactory: ConverterFactory
) : CoinGeckoRepository {

    override fun getCoinMarket(): Single<List<CoinMarkets>> {
        val converter = convertFactory.getConverter(
            CoinMarketsResponse::class.java, CoinMarkets::class.java)
        return coinGeckoApi.getCoinMarket().map(converter::convert)
    }

}