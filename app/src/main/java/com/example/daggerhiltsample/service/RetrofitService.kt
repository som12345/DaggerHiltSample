package com.example.daggerhiltsample.service

import com.example.daggerhiltsample.model.AndroidModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("android/jsonandroid")
    suspend fun getAndroidList(): Response<AndroidModel>
}