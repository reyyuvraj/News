package com.example.news.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsClient {

    private const val baseURL = "https://newsapi.org/"

    fun getClient(): NewsService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseURL)
            .build()

        val retrofitService: NewsService by lazy {
            retrofit.create(NewsService::class.java)
        }
        return retrofitService
    }
}