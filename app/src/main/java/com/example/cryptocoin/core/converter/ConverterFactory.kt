package com.example.cryptocoin.core.converter

/**
 * Интерфейс фабрики для получения конвертеров моделей данных
 */
interface ConverterFactory {
    fun <T, S> getConverter(clazzFrom: Class<T>, clazzTo: Class<S>): OneWayConverter<T, S>
}