package com.example.cryptocoin.di

import com.example.cryptocoin.data.bean.converter.CoinConverterFactory
import com.example.cryptocoin.data.repository.CoinGeckoRepositoryImpl
import com.example.cryptocoin.data.repository.api.CoinGeckoApi
import com.example.cryptocoin.domain.repository.CoinGeckoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class AppModule(private val baseUrl: String) {

    @AppScope
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @AppScope
    @Provides
    fun provideGsonConvertFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @AppScope
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @AppScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

    @AppScope
    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory, callAdapterFactory: RxJava2CallAdapterFactory,
                        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()

    @AppScope
    @Provides
    fun provideCoinGeckoApi(retrofit: Retrofit): CoinGeckoApi = retrofit.create(CoinGeckoApi::class.java)

    @AppScope
    @Provides
    fun provideCoinGeckoRepository(api: CoinGeckoApi): CoinGeckoRepository = CoinGeckoRepositoryImpl(api, CoinConverterFactory())
}