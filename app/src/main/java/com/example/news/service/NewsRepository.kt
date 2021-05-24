package com.example.news.service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news.data.NewsDataItem
import retrofit2.Response

class NewsRepository {
    suspend fun getData(country: String, apiKey: String): Response<NewsDataItem>{
        return NewsClient.service.getData(country, apiKey)
    }
}

