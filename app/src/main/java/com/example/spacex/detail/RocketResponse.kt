package com.example.spacex.detail

import com.squareup.moshi.Json

data class RocketResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String,
)
