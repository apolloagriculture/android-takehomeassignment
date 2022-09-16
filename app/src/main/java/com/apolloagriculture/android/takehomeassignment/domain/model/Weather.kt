package com.apolloagriculture.android.takehomeassignment.domain.model

data class Weather(
    val description: String,
    val highTemp: Double,
    val icon: String,
    val lowTemp: Double
)
