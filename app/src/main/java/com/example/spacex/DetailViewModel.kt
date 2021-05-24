package com.example.spacex

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(id: String) : ViewModel() {
    val liveDetailItem: MutableLiveData<RocketResponse> = MutableLiveData()
    private val networkService: NetworkService = NetworkService()

    init {
        try {
            viewModelScope.launch {
                val result =
                    withContext(Dispatchers.Default) { networkService.api.getRocket(id) }
                liveDetailItem.value = result
            }
        } catch (e: Exception) {
            Log.e("DetailViewModel", e.message!!)
        }
    }
}