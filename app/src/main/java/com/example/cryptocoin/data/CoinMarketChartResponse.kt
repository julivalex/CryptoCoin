package com.example.cryptocoin.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinMarketChartResponse(

    @SerializedName("prices")
    @Expose
    var prices: List<List<Float>>
)