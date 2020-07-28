package com.profico.smartmarina.di

import com.profico.smartmarina.data.remote.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Pero on 25/05/2020.
 */

val retrofitModule = module {

    fun provideMoshiBuilder() =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    fun provideOkHttpClient(): OkHttpClient =

        OkHttpClient.Builder()
//            .addInterceptor(HeaderInterceptor())
//            .addInterceptor(ResponseInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

    fun provideRetrofitClient(okHttpClient: OkHttpClient, moshiBuilder: Moshi): Retrofit =

        Retrofit.Builder()
            .baseUrl("https://api.smart-marina.proficodev.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
            .build()

    single { provideMoshiBuilder() }
    single { provideOkHttpClient() }
    single { provideRetrofitClient(get(), get()) }
}

val apiModule = module {

    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java)

    single { provideApiService(get()) }
}