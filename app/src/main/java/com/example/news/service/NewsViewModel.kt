package com.example.news.service

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.NewsDataItem
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    val myResponse: MutableLiveData<Response<NewsDataItem>> = MutableLiveData()

    fun getData(country: String, apiKey: String) {
        viewModelScope.launch {
            val resp = repository.getData(country, apiKey)
            myResponse.value = resp
        }
    }
}