package com.example.news.service

import com.example.news.service.NewsDataItem
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("v2")
    fun getMarsData(): Call<List<NewsDataItem>>
}