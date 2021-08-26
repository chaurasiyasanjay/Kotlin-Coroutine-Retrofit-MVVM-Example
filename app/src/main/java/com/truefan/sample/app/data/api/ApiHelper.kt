package com.truefan.sample.app.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getData() = apiService.getData()
}