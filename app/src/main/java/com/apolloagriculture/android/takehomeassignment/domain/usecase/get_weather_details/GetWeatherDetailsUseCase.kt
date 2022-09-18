package com.apolloagriculture.android.takehomeassignment.domain.usecase.get_weather_details

import com.apolloagriculture.android.takehomeassignment.common.Resource
import com.apolloagriculture.android.takehomeassignment.domain.model.Weather
import com.apolloagriculture.android.takehomeassignment.domain.repository.ApolloWeatherRepository
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetWeatherDetailsUseCase @Inject constructor(
    private val repository: ApolloWeatherRepository
) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<Weather>> = flow {
        try {
            emit(Resource.Loading())
            val weatherDetails = repository.getWeatherDetails()
            emit(Resource.Success(weatherDetails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}
