package com.apolloagriculture.android.takehomeassignment.domain.repository

import com.apolloagriculture.android.takehomeassignment.domain.model.Weather

interface ApolloWeatherRepository {

    suspend fun getWeatherDetails(): Weather
}
