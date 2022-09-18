package com.apolloagriculture.android.takehomeassignment.data.repository

import com.apolloagriculture.android.takehomeassignment.domain.model.DayAfterTomorrow
import com.apolloagriculture.android.takehomeassignment.domain.model.Today
import com.apolloagriculture.android.takehomeassignment.domain.model.Tomorrow
import com.apolloagriculture.android.takehomeassignment.domain.model.Weather
import com.apolloagriculture.android.takehomeassignment.domain.repository.ApolloWeatherRepository

class FakeRepository : ApolloWeatherRepository {

    private val weather: Weather = Weather(
        dayAfterTomorrow = DayAfterTomorrow(
            description = "",
            highTemp = 0.0,
            icon = "",
            lowTemp = 0.0
        ),
        today = Today(
            description = "",
            highTemp = 0.0,
            icon = "",
            lowTemp = 0.0
        ),
        tomorrow = Tomorrow(
            description = "",
            highTemp = 0.0,
            icon = "",
            lowTemp = 0.0
        )
    )
    override suspend fun getWeatherDetails(): Weather {
        return weather
    }
}
