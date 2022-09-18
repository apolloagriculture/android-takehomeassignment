package com.apolloagriculture.android.takehomeassignment.components

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.apolloagriculture.android.takehomeassignment.MainActivity
import com.apolloagriculture.android.takehomeassignment.data.repository.FakeRepository
import com.apolloagriculture.android.takehomeassignment.domain.usecase.get_weather_details.GetWeatherDetailsUseCase
import com.apolloagriculture.android.takehomeassignment.presentation.weather_details.WeatherDetailsViewModel
import com.apolloagriculture.android.takehomeassignment.presentation.weather_details.WeatherListScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class WeatherListScreenTest {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var fakeRepository: FakeRepository

    lateinit var getWeatherDetailsUseCase: GetWeatherDetailsUseCase

    private lateinit var viewModel: WeatherDetailsViewModel

    @Before
    fun setup() {
        hiltTestRule.inject()
        fakeRepository = FakeRepository()
        getWeatherDetailsUseCase = GetWeatherDetailsUseCase(fakeRepository)
    }

    @Test
    fun testTodayWeatherIsDisplayed() {
        composeTestRule.activity.setContent {
            viewModel = WeatherDetailsViewModel(getWeatherDetailsUseCase)
            WeatherListScreen(viewModel)
        }
        composeTestRule.onNodeWithText("Today").assertIsDisplayed()
        composeTestRule.onAllNodes(hasText("Low")).assertAny(isEnabled())
        composeTestRule.onAllNodes(hasText("High")).assertAny(isEnabled())
    }

    @Test
    fun testTomorrowWeatherIsDisplayed() {
        composeTestRule.activity.setContent {
            viewModel = WeatherDetailsViewModel(getWeatherDetailsUseCase)
            WeatherListScreen(viewModel)
        }
        composeTestRule.onNodeWithText("Tomorrow").assertIsDisplayed()
        composeTestRule.onAllNodes(hasText("Low")).assertAny(isEnabled())
        composeTestRule.onAllNodes(hasText("High")).assertAny(isEnabled())
    }

    @Test
    fun testDayAfterTomorrowWeatherIsDisplayed() {
        composeTestRule.activity.setContent {
            viewModel = WeatherDetailsViewModel(getWeatherDetailsUseCase)
            WeatherListScreen(viewModel)
        }
        composeTestRule.onNodeWithText("Day After Tomorrow").assertIsDisplayed()
        composeTestRule.onAllNodes(hasText("Low")).assertAny(isEnabled())
        composeTestRule.onAllNodes(hasText("High")).assertAny(isEnabled())
    }
}
