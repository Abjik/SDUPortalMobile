package com.example.sdu_portal_mobile.domain.repository

import com.example.sdu_portal_mobile.domain.util.Resource
import com.example.sdu_portal_mobile.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}