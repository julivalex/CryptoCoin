package com.example.cryptocoin.data.api

import com.example.cryptocoin.data.CoinMarketChartResponse
import com.example.cryptocoin.data.CoinMarketsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {

    //запрос списка криптовалют
    @GET("coins/markets")
    fun getCoinMarket(
        @Query("vs_currency") vs: String = "usd",
        @Query("per_page") perPage: Int = 100,
        @Query("sparkline") sparkline: Boolean = false,
        @Query("order") order: String = "market_cap_desc"
    ): Single<CoinMarketsResponse>

    //запрос данных для графика
    @GET("coins/{id}/market_chart")
    fun getCoinMarketChart(
        @Path("id") id: String,
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("days") days: String = "max"
    ): Single<CoinMarketChartResponse>
}