package com.example.spacex.network

import com.example.spacex.list.LaunchResponse
import com.example.spacex.detail.RocketResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchApi {
    @GET("v4/launches")
    suspend fun getAllLaunches(): List<LaunchResponse>
    @GET("v4/rockets/{id}")
    suspend fun getRocket(@Path("id") id: String): RocketResponse
}