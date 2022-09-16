package com.apolloagriculture.android.takehomeassignment.data.remote.dto

data class WeatherDto(
    val description: String,
    val highTemp: Double,
    val icon: String,
    val lowTemp: Double
)
