package com.lzbtech.arch_test.repository.network

import com.lzbtech.arch_test.repository.model.DailyWeatherResponse
import retrofit2.http.GET

interface WeatherService {

    @GET("/v3/weather/weatherInfo?city=110101&key=cb03913191c73dff53cf6e1c94e41c97")
    suspend fun getWeather(): DailyWeatherResponse
}