package com.example.daggerhiltsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltsample.model.AndroidModel
import com.example.daggerhiltsample.model.ApiResponseData
import com.example.daggerhiltsample.service.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OsListViewModel @Inject constructor(
    private val mainRepository: ApiRepository
):  ViewModel() {

    private val list_os = MutableLiveData<ApiResponseData<AndroidModel>>()
    val listOs: LiveData<ApiResponseData<AndroidModel>>
        get() = list_os

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
                list_os.postValue(ApiResponseData.onLoading(null))
                mainRepository.getApiList().let {
                    if (it.isSuccessful) {
                        list_os.postValue(ApiResponseData.onSuccess(it.body()))
                    } else {
                       list_os.postValue(ApiResponseData.onFailure(
                           "error fetching list", null
                       ))
                    }
                }
        }
    }
}