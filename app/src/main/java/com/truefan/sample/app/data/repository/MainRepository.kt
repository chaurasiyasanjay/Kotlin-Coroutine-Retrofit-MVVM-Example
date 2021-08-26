package com.truefan.sample.app.data.repository

import com.truefan.sample.app.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getData() = apiHelper.getData()
}