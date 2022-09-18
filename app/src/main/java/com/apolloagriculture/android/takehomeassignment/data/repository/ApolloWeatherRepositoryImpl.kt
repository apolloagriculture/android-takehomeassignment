package com.apolloagriculture.android.takehomeassignment.data.repository

import com.apolloagriculture.android.takehomeassignment.data.remote.ApolloApi
import com.apolloagriculture.android.takehomeassignment.domain.model.Weather
import com.apolloagriculture.android.takehomeassignment.domain.repository.ApolloWeatherRepository
import javax.inject.Inject

class ApolloWeatherRepositoryImpl @Inject constructor(
    private val api: ApolloApi
) : ApolloWeatherRepository {

    override suspend fun getWeatherDetails(): Weather {
        return api.getWeatherDetails()
    }
}
