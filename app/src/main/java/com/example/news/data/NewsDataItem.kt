package com.example.news.data

data class NewsDataItem (
    val status: String,
    val totalResults: Int,
    val articles: List<NewsInfo>
)