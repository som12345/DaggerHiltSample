package com.example.daggerhiltsample.service

import com.example.daggerhiltsample.model.AndroidModel
import retrofit2.Response

interface ApiHelper {
    suspend fun getApiList(): Response<AndroidModel>
}