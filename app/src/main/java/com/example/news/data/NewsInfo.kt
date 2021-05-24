package com.example.news.data

data class NewsInfo(
    val source: List<NewsSource>,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)
