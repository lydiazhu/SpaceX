package com.example.spacex

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface LaunchApi {
    @GET("v4/launches")
//    fun getAllLaunches() : Observable<List<LaunchResponse>>
    suspend fun getAllLaunches(): List<LaunchResponse>
}