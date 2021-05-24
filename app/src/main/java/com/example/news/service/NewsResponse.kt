package com.example.news.service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsResponse(private val repository: NewsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }
}