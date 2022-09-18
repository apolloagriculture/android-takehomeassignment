package com.apolloagriculture.android.takehomeassignment.presentation.weather_details

import com.apolloagriculture.android.takehomeassignment.domain.model.Weather

data class WeatherDetailsState(
    val isLoading: Boolean = false,
    val weatherDetails: Weather? = null,
    val error: String = ""
)
