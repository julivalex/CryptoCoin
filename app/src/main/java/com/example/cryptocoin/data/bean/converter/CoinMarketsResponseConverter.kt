package com.example.cryptocoin.data.bean.converter

import com.example.cryptocoin.core.OneWayConverter
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
                    it.marketCapRank ?: throw IllegalArgumentException(),
                    it.totalVolume ?: throw IllegalArgumentException(),
                    it.priceChangePercentage24h ?: throw IllegalArgumentException(),
                    it.marketCapChangePercentage24h ?: throw IllegalArgumentException(),
                    it.circulatingSupply ?: throw IllegalArgumentException(),
                    it.totalSupply ?: throw IllegalArgumentException(),
                    it.ath ?: throw IllegalArgumentException(),
                    it.athChangePercentage ?: throw IllegalArgumentException()
                )
            } catch (ex: Exception) {
                null
            }
        }
    }
}