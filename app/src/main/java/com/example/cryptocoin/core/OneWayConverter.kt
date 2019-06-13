package com.example.cryptocoin.core

abstract class OneWayConverter<T, U> {

    /**
     * Преобразование одной модели в другую
     *
     * @param source исходная модель данных
     * @return преобразованная модель или <code>null</code>
     */
    abstract fun convert(source: T?): U?

    /**
     * Преобразование списка моделей к списку с преобразованными моделями
     *
     * Результирующий список не содержит <code>null</code>-объектов
     *
     * @param source список с исходными моделями данных
     * @return список с не-<code>null</code> преобразованными моделями
     */
    fun convert(source: List<T?>): List<U> {
        val result = ArrayList<U>()
        source.forEach{ item ->
            convert(item)?.let {
                result.add(it)
            }
        }
        return result
    }
}