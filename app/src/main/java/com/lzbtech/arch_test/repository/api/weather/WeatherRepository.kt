package com.lzbtech.arch_test.repository.api.weather

import com.lzbtech.arch_test.repository.model.DailyWeatherResponse

interface WeatherRepository {

    suspend fun getWeather(): DailyWeatherResponse?
}