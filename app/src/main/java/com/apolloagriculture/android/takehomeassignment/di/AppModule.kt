package com.apolloagriculture.android.takehomeassignment.di

import com.apolloagriculture.android.takehomeassignment.common.Constants
import com.apolloagriculture.android.takehomeassignment.data.remote.ApolloApi
import com.apolloagriculture.android.takehomeassignment.data.repository.ApolloWeatherRepositoryImpl
import com.apolloagriculture.android.takehomeassignment.domain.repository.ApolloWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApolloApi(): ApolloApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApolloApi::class.java)
    }

    @Provides
    @Singleton
    fun providesApolloWeatherRepository(api: ApolloApi): ApolloWeatherRepository{
        return ApolloWeatherRepositoryImpl(api)
    }
}