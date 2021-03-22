package com.example.daggerhiltsample.service

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getApiList() = apiHelper.getApiList()
}