package com.example.sdu_portal_mobile.data.repository

import com.example.sdu_portal_mobile.data.mappers.toWeatherInfo
import com.example.sdu_portal_mobile.data.remote.WeatherApi
import com.example.sdu_portal_mobile.domain.repository.WeatherRepository
import com.example.sdu_portal_mobile.domain.util.Resource
import com.example.sdu_portal_mobile.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        }   catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occured")
        }
    }
}