package com.example.news.service

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.news.service.NewsClient
import com.example.news.service.NewsDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(val application: Application) {
    val showProgress = MutableLiveData<Boolean>()
    val marsData = MutableLiveData<List<NewsDataItem>>()

    fun getNewsData() {
        showProgress.value = true

        val retrofitService = NewsClient.getClient()
        val callApi = retrofitService.getMarsData()


        callApi.enqueue(object : Callback<List<NewsDataItem>> {
            override fun onFailure(call: Call<List<NewsDataItem>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(
                call: Call<List<NewsDataItem>>,
                response: Response<List<NewsDataItem>>
            ) {
                showProgress.value = false
                val marsDataList = response.body()
                marsData.value = marsDataList
            }
        })
    }
}