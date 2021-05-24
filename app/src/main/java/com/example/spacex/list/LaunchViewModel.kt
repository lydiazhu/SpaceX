package com.example.spacex.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LaunchViewModel : ViewModel() {
    val liveLaunchItems: MutableLiveData<List<LaunchResponse>> = MutableLiveData()
    private val networkService: NetworkService = NetworkService()

    init {
        try {
            viewModelScope.launch {
                val result = withContext(Dispatchers.Default) { networkService.api.getAllLaunches() }
                liveLaunchItems.value = result
            }
        } catch (e: Exception) {

            Log.e("LaunchViewModel", e.message!!)
        }
    }
}