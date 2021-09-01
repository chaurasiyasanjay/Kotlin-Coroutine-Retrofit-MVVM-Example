package com.retrofit.coroutine.mvvm.data.repository

import com.retrofit.coroutine.mvvm.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getData() = apiHelper.getData()
}