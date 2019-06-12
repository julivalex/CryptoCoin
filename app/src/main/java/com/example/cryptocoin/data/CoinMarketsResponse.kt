package com.example.cryptocoin.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinMarketsResponse(

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("symbol")
    @Expose
    val symbol: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("image")
    @Expose
    val image: String,

    @SerializedName("current_price")
    @Expose
    val currentPrice: Float,

    @SerializedName("market_cap")
    @Expose
    val marketCap: Float,

    @SerializedName("market_cap_rank")
    @Expose
    val marketCapRank: Int,

    @SerializedName("total_volume")
    @Expose
    val totalVolume: Float,

    @SerializedName("price_change_percentage_24h")
    @Expose
    val priceChangePercentage24h: Float,

    @SerializedName("market_cap_change_percentage_24h")
    @Expose
    val marketCapChangePercentage24h: Float,

    @SerializedName("circulating_supply")
    @Expose
    val circulatingSupply: Double,

    @SerializedName("total_supply")
    @Expose
    val totalSupply: Long,

    @SerializedName("ath")
    @Expose
    val ath: Float,

    @SerializedName("ath_change_percentage")
    @Expose
    val athChangePercentage: Float

)