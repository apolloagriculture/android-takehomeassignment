package com.apolloagriculture.android.takehomeassignment.presentation.weather_details

import com.apolloagriculture.android.takehomeassignment.common.Resource
import com.apolloagriculture.android.takehomeassignment.dispatcher.MainDispatcherRule
import com.apolloagriculture.android.takehomeassignment.domain.model.Weather
import com.apolloagriculture.android.takehomeassignment.domain.usecase.get_weather_details.GetWeatherDetailsUseCase
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.any

@ExperimentalCoroutinesApi
class WeatherDetailsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private var useCase: GetWeatherDetailsUseCase = mockk(relaxed = true)

    @Test
    fun `for success resource, data must be available`() = runTest {
        every { useCase() } returns flow { Resource.Success<Weather>(any()) }
        val viewModel = WeatherDetailsViewModel(useCase) // creating view model object
        assertNotNull(viewModel.state.value)
    }

    @Test
    fun `for loading resource, data should be null && isLoading should be true`() = runTest {
        every { useCase() } returns flow { Resource.Loading<Weather>() }
        val viewModel = WeatherDetailsViewModel(useCase)
        assertThat(viewModel.state.value.isLoading.toString(), true)
        assertNull(viewModel.state.value.weatherDetails)
    }

    @Test
    fun `for error resource, data should be null`() = runTest {
        every { useCase() } returns flow { Resource.Error<Weather>("Error") }
        val viewModel = WeatherDetailsViewModel(useCase)
        assertThat(viewModel.state.value.error, true)
        assertNull(viewModel.state.value.weatherDetails)
    }
}

