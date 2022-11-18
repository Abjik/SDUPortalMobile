package com.example.sdu_portal_mobile.presentation

import com.example.sdu_portal_mobile.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null

) {
}