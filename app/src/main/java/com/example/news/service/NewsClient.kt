package com.example.news.service


import com.example.news.service.NewsService.Companion.baseURL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NewsClient {

    val newsCall : NewsService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        newsCall = retrofit.create(NewsService::class.java)
    }
}



















/*


object NewsClient {

    fun getClient(): NewsService {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseURL)
            .build()

        val retrofitService: NewsService by lazy {
            retrofit.create(NewsService::class.java)
        }
        return retrofitService
    }
}


 */