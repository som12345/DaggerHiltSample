package com.example.daggerhiltsample.service

import com.example.daggerhiltsample.model.AndroidModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : ApiHelper {
    override suspend fun getApiList(): Response<AndroidModel> =
        retrofitService.getAndroidList()


}