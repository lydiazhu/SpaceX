package com.example.spacex

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

class NetworkService {
    private val retrofit: Retrofit = Builder()
        .baseUrl("https://api.spacexdata.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api: LaunchApi = retrofit.create(LaunchApi::class.java)
}