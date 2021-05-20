package com.example.news.service

data class NewsDataItem (
    val status: String,
    val totalResults: Int,
    val articles: List<NewsInfo>,
)