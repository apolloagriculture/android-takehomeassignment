package com.apolloagriculture.android.takehomeassignment.presentation.weather_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apolloagriculture.android.takehomeassignment.R
import com.apolloagriculture.android.takehomeassignment.domain.model.DayAfterTomorrow

@Composable
fun DayAfterTomorrow(dayAfterTomorrow: DayAfterTomorrow) {
    DayAfterTomorrowScreen(weather = dayAfterTomorrow)
}

@Composable
fun DayAfterTomorrowScreen(
    weather: DayAfterTomorrow
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Day After Tomorrow",
                    style = MaterialTheme.typography.bodyMedium
                )
                Row() {
                    Text(
                        text = weather.highTemp.toString(),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = "High",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start
                    )
                }
                Row() {
                    Text(
                        text = weather.lowTemp.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Low",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(16.dp),
                    painter = painterResource(id = R.drawable.ic_weather_some_clouds),
                    contentDescription = weather.icon
                )
                Text(
                    text = weather.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DayAfterTomorrowPreview() {
    DayAfterTomorrowScreen(
        weather = DayAfterTomorrow(
            description = "Clear sky",
            highTemp = 23.36,
            lowTemp = 22.0,
            icon = ""
        )
    )
}
