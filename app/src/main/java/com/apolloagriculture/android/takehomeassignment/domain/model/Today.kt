package com.apolloagriculture.android.takehomeassignment.domain.model

data class Today(
    val description: String,
    val highTemp: Double,
    val icon: String,
    val lowTemp: Double
)