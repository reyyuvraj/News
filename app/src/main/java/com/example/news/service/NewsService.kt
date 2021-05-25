package com.example.news.service

import com.example.news.data.NewsDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    companion object {
        const val baseURL: String = "https://newsapi.org/"
        const val apiKey: String = "985a6f9b900e45558154bfbd4200103e"
    }

    @GET("v2/top-headlines?apiKey=$apiKey")
    fun getData(
        @Query("country") country: String,
        @Query("page") page: Int
    ): Call<NewsDataItem>
}