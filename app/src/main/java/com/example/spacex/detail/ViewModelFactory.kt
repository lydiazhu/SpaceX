package com.example.spacex.detail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(param: String) : ViewModelProvider.Factory {
    private val mParam: String = param
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(mParam) as T
    }
}