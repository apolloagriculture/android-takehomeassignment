package com.apolloagriculture.android.takehomeassignment.domain.model

data class Weather(
    val dayAfterTomorrow: DayAfterTomorrow,
    val today: Today,
    val tomorrow: Tomorrow
)
