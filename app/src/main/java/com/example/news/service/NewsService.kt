package com.example.news.service

import com.example.news.data.NewsDataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/top-headlines")
    fun getData(@Query("country") country :String = "in",
                @Query("apiKey") apiKey :String  = NewsConstants.apiKey
    ) : Response<NewsDataItem>
}