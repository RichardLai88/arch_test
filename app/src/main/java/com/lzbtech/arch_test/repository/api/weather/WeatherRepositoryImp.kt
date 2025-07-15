package com.lzbtech.arch_test.repository.api.weather

import com.lzbtech.arch_test.repository.model.DailyWeatherResponse
import com.lzbtech.arch_test.repository.network.WeatherService

class WeatherRepositoryImp (val weatherService: WeatherService) : WeatherRepository {

    override suspend fun getWeather(): DailyWeatherResponse? {
        return weatherService.getWeather()
    }
}