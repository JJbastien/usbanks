package com.example.usbanks.apiService


import javax.inject.Inject

class NewsRepository @Inject constructor(private val service: NewsApiService) {
    @Inject
    suspend fun getNews() = service.getNewshealines()
}