package com.apolloagriculture.android.takehomeassignment.data.remote

import com.apolloagriculture.android.takehomeassignment.domain.model.Weather
import retrofit2.http.GET

interface ApolloApi {
    @GET(value = "recruitment/android/weather.json")
    suspend fun getWeatherDetails(): Weather
}