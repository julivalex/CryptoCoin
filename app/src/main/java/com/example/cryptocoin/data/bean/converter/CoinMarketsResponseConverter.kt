package com.example.cryptocoin.data.bean.converter

import com.example.cryptocoin.core.converter.OneWayConverter
import com.example.cryptocoin.data.bean.response.CoinMarketsResponse
import com.example.cryptocoin.domain.model.CoinMarkets
import java.lang.Exception

class CoinMarketsResponseConverter : OneWayConverter<CoinMarketsResponse, CoinMarkets>() {

    override fun convert(source: CoinMarketsResponse?): CoinMarkets? {
        return source?.let {
            try {
                CoinMarkets(
                    it.id ?: throw IllegalArgumentException(),
                    it.symbol ?: throw IllegalArgumentException(),
                    it.name ?: throw IllegalArgumentException(),
                    it.image ?: throw IllegalArgumentException(),
                    it.currentPrice ?: throw IllegalArgumentException(),
                    it.marketCap ?: throw IllegalArgumentException(),
                    it.marketCapRank ?: 0,
                    it.totalVolume ?: 0.0F,
                    it.priceChangePercentage24h ?: 0.0F,
                    it.marketCapChangePercentage24h ?: 0.0F,
                    it.circulatingSupply ?: 0.0,
                    it.totalSupply ?: 0L,
                    it.ath ?: 0.0F,
                    it.athChangePercentage ?: throw IllegalArgumentException()
                )
            } catch (ex: Exception) {
                null
            }
        }
    }
}