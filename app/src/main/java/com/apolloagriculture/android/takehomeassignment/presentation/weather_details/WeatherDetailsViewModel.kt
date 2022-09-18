package com.apolloagriculture.android.takehomeassignment.presentation.weather_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolloagriculture.android.takehomeassignment.common.Resource
import com.apolloagriculture.android.takehomeassignment.domain.usecase.get_weather_details.GetWeatherDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherDetailsViewModel @Inject constructor(
    private val getWeatherDetailsUseCase: GetWeatherDetailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WeatherDetailsState())
    val state: State<WeatherDetailsState> = _state

    init {
        onEvent()
    }
    private fun onEvent() {
        getWeatherDetailsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = WeatherDetailsState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = WeatherDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = WeatherDetailsState(
                        weatherDetails = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
