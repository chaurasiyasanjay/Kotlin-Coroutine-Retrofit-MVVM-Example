package com.retrofit.coroutine.mvvm.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getData() = apiService.getData()
}