package com.example.daggerhiltsample.model

data class ApiResponseData<out T>(
    val status: ResponseEnum,
    val data: T?,
    val message: String?
) {
    companion object {
        fun <T> onSuccess(data: T?): ApiResponseData<T> {
            return ApiResponseData(ResponseEnum.SUCCESS, data, null)
        }

        fun <T> onFailure(msg: String, data: T?): ApiResponseData<T> {
            return ApiResponseData(ResponseEnum.FAILURE, data, message = msg)
        }

        fun <T> onLoading(data: T?): ApiResponseData<T> {
            return ApiResponseData(ResponseEnum.LOADING, data, null)
        }
    }


}
