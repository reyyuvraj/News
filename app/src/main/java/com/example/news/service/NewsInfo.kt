package com.example.news.service

data class NewsInfo(
    val source: List<NewsSource>,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content:String
)
