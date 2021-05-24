package com.example.news.service

import com.example.news.service.NewsConstants.Companion.baseURL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsClient {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service : NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }
}



















/*


object NewsClient {

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


 */