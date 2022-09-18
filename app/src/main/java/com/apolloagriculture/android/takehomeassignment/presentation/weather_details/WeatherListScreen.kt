package com.apolloagriculture.android.takehomeassignment.presentation.weather_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.apolloagriculture.android.takehomeassignment.presentation.weather_details.components.DayAfterTomorrow
import com.apolloagriculture.android.takehomeassignment.presentation.weather_details.components.Today
import com.apolloagriculture.android.takehomeassignment.presentation.weather_details.components.Tomorrow

@Composable
fun WeatherListScreen(
    viewModel: WeatherDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.weatherDetails != null) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Today(state.weatherDetails.today)
                Tomorrow(state.weatherDetails.tomorrow)
                DayAfterTomorrow(state.weatherDetails.dayAfterTomorrow)
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherListScreenPreview() {
    WeatherListScreen()
}
