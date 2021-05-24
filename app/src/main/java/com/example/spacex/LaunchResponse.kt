package com.example.spacex

import com.squareup.moshi.Json

data class LaunchResponse(
    @Json(name = "links")
    val links: Links,
    @Json(name = "name")
    val name: String,
    @Json(name = "date_utc")
    val date: String,
    @Json(name = "success")
    val success: Boolean?,
    @Json(name = "upcoming")
    val upcoming: Boolean,
    @Json(name = "rocket")
    val rocket: String
)

data class Links(
    @Json(name = "patch")
    val patch: Patch
)

data class Patch(
    @Json(name = "small")
    val small: String,
    @Json(name = "large")
    val large: String
)