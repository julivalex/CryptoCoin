package com.example.cryptocoin.data.bean.converter

import com.example.cryptocoin.core.converter.ConverterFactory
import com.example.cryptocoin.core.converter.OneWayConverter
import com.example.cryptocoin.data.bean.response.CoinMarketsResponse

class CoinConverterFactory: ConverterFactory {

    private val coinMarketsResponseConverter = CoinMarketsResponseConverter()

    @Suppress("UNCHECKED_CAST")
    override fun <T, S> getConverter(clazzFrom: Class<T>, clazzTo: Class<S>): OneWayConverter<T, S> =
        when(clazzFrom) {
            CoinMarketsResponse::class.java -> coinMarketsResponseConverter
            else -> throw IllegalStateException(
                "Converter from ${clazzFrom.simpleName} to ${clazzTo.simpleName} not found"
            )
        } as OneWayConverter<T, S>
    }
